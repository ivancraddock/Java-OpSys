package com.opsys;

/*
Ivan Craddock
CSCD 300 Armstrong
Assignment 2
This Job is used to simulate activity on the simulated CPU of the Operating System class.
*/
public class Job {

	String jobName;
	int runTime;
	int startTime;
	int remainTime;

	/**
	 * DVC for Job class
	 */
	public Job() {
		jobName = "";
		runTime = 0;
		remainTime = 0;
		startTime = 0;

	}// end job evc

	/**
	 * DVC for Job class
	 * 
	 * @param String
	 * @param int
	 */
	public Job(String _jobName, int _runTime) {
		this.jobName = _jobName;
		this.runTime = _runTime;
		this.remainTime = _runTime;
		this.startTime = 0;

	}

	/**
	 * Method used to simulate processing on CPU. Takes an input of type int and
	 * subtracts input from remainTime. Will return extra time in the form of
	 * int.
	 * 
	 * @param int
	 * @return int
	 */
	public int run(int prime) {
		int remainder;
		if (this.remainTime >= prime) {
			this.remainTime = this.remainTime - prime;
			this.startTime = this.startTime + prime;
			return 0;
		} else {
			remainder = prime - this.remainTime;

			this.remainTime = 0;
			this.startTime = this.startTime + (prime - remainder);
			return remainder;
		}

	}

	/**
	 * Returns Job name, remainTime, and runTime in the form of a String
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		String result = ("" + this.jobName + " (" + this.remainTime + "/" + this.runTime + "ms)\n");
		return result;
	}

}// end job