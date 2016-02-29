package com.opsys;
/*
Ivan Craddock
CSCD 300 Armstrong
Assignment 2

This LinkedQueue class is a custom version of the Linked List class from the java API.

This class is submitted for 30 points of extra credit in conjunction with the LinkedList class
*/

public class LinkedQueue extends LinkedList {

	/**
	 * DVC for LinkedQueue
	 */
	public LinkedQueue() {
		super();
	}

	/**
	 * Adds objects to back of LinkedQueue in the form of nodes
	 * 
	 * @param Object
	 * 
	 */
	public void enQ(Object data) {
		this.addNode(data);
		this.tail = tailMaker();
	}

	/**
	 * Removes objects to front of LinkedQueue
	 */
	public void deQ() {
		if (this.size == 0) {
			System.out.println("Error: Queue is empty");
		} else {
			Node prime = this.head;
			prime = prime.next;
			this.setHead(prime);
			this.tail = tailMaker();
			this.size--;
		}

		// Node curr = this.getHead();
		// if(curr.isLast() == false){
		//
		// Node prev = curr;
		// curr = curr.next;
		// while(curr.isLast() == false){
		// curr = curr.next;
		// prev = prev.next;
		// }//end while
		// prev.next =null;
		// }//end if
		// else
		// this.head = new Node();
		//
	}// end deQ

	/**
	 * Returns the node at the front of LinkedQueue
	 * 
	 * @return Node
	 */
	public Node peek() {
		this.tail = tailMaker();
		return this.tail.next;
	}

	/**
	 * Returns a boolean to indicate if LinkedQueue is empty
	 * 
	 * @return boolean
	 */
	@Override
	public boolean isEmpty() {
		if (this.head == null) {
			return true;
		} else
			return false;
	}

	/**
	 * Returns a string indicating LinkdeQueue size and contents
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		Node prime = this.head;
		String result = ("Linked Queue (" + this.size + " items total)\n-------------------------------\n");
		while (prime != null) {
			result = (result + prime.data.getClass() + ": " + prime.data);// Job
																			// objects
																			// have
																			// their
																			// own
																			// "\n",
																			// may
																			// need
																			// revision
																			// for
																			// other
																			// objects
			prime = prime.next;
		}

		return result;
	}

}