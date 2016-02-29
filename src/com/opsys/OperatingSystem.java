package com.opsys;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Random;

/*
Ivan Craddock
CSCD 300 Armstrong
Assignment 2

*This program will simulate the activity of an operating system by taking a list of
jobs and then executing them in a series for a set amount of time. Some jobs will
require multiple executions in order to complete. Completed jobs are removed from
their position in the job Queue.

Random I/O binding error simulation implemented for extra credit

*/
public class OperatingSystem {

	/*
	 * The main method accepts 3 or 4 command line arguments as parameters:
	 *
	 * @param String[] Accepts an array of strings from the command line
	 *
	 * args[0] An string name for an input file. If the input file is properly
	 * formatted, it will be scanned and its contents will be added to a job
	 * queue to be performed by this class. A sample file called "args.txt" is
	 * included to show proper formatting
	 * 
	 * args[1] An int used to simulate the Operating System's latency (time
	 * spent loading jobs into the CPU).
	 * 
	 * args[2] An int used to simulate the Operatign System's time slice (time
	 * spent on each task loaded into the CPU).
	 * 
	 * args[3] (Optional) An int used to simulate potential I/O binding that
	 * prevents job execution. This integer is compared to a random dice roll to
	 * determine job execution
	 */
	public static void main(String[] args) {
		LinkedQueue waitQ = new LinkedQueue();
		LinkedQueue runQ = new LinkedQueue();
		Random dice = new Random(42);

		String fileName = "no_fileName";
		int slice = 0, timeSW = 0, skip = 0;

		// ------------------------------
		if (args.length < 3 && args.length > 4)
			throw new IllegalStateException("No command line arguments...\n");

		fileName = args[0];
		timeSW = Integer.parseInt(args[2]);
		slice = Integer.parseInt(args[1]);

		if (args.length > 3) {
			skip = Integer.parseInt(args[3]);
		}

		System.out.println("\nTime Slice: " + timeSW);
		System.out.println("Latency: " + slice);
		System.out.println("Chance for I/O error: " + skip + " \n");
		Job job = null;

		try {

			FileInputStream fstream = new FileInputStream(fileName);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			boolean first = true;
			while ((strLine = br.readLine()) != null) {
				if (job == null)
					job = new Job("", 0);

				strLine = strLine.trim();

				if (strLine.startsWith("#"))
					continue;
				if (strLine.length() == 0)
					continue;

				if (first) {
					job.jobName = strLine;
					first = false;

				} // end if first
				else {
					job.runTime = Integer.parseInt(strLine);
					job.remainTime = job.runTime;
					job.startTime = 0;

					System.out.println(job.jobName + ", " + job.runTime + " milliseconds to execute.");

					waitQ.enQ(job);

					job = null;
					first = true;
				} // end else

			} // end while
			in.close();
		} // end try
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
		} // end catch
		System.out.println("\nBegin Job Processing\n--------------------");
		int elapsed = 0;

		while (waitQ.size > 0) {// major while loop
			// will direct all activity for job Queue execution
			int reps = waitQ.size;
			for (int i = 0; i < reps; i++) {
				Job loader = (Job) waitQ.tail.next.data;
				if (loader.remainTime > 0) {
					// runQ loading loop from waitQ
					runQ.enQ(loader);
				}
				waitQ.deQ();

			}
			int runReps = runQ.size;
			if (runQ.size == 1) {
				Job runner = (Job) runQ.tail.next.data;// tail.next == head,
														// more stable for some
														// reason
				elapsed = elapsed + runner.remainTime;
				System.out.println(runner.jobName + " is complete. Total time to execute: " + elapsed);

			} else {
				for (int i = 0; i < runReps; i++) {
					Job runner = (Job) runQ.tail.next.data;// tail.next == head,
															// more stable for
															// some reason
					int stopper = dice.nextInt(100);
					if (stopper >= skip) {

						System.out.println("Executing " + runner.jobName + ", " + runner.remainTime + " ms remaining");
						int remainder = runner.run(timeSW);
						elapsed = elapsed + (timeSW - remainder);
					} else
						System.out.println("Job " + runner.jobName + " not executed due to I/O error");

					waitQ.enQ(runner);
					elapsed = elapsed + slice;

					if (runner.remainTime <= 0) {
						System.out.println(runner.jobName + " is complete. Total time to execute: " + elapsed);
					}
					runQ.deQ();
				}
			}
		} // end major while
		System.out.println("All jobs complete");
	}// end main
}// end quetester