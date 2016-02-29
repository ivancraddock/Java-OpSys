/*
Ivan Craddock
CSCD 300 Armstrong
Assignment 2

QueueSimulation class runs OpperatingSystem class 
*/
package com.opsys;

public class QueueSimulation {
	/**
	 * Main method for running OpperatingSystem a sample file called "args.txt"
	 * is included to show proper formatting
	 */
	public static void main(String[] args) {
		if (args.length < 1) {
			String[] no_args = { "args.txt", "10", "50", "5" };
			OperatingSystem.main(no_args);
		} else {
			OperatingSystem.main(args);
		}

	}// end main

}// end quetester