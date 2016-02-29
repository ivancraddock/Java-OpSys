package com.opsys;

//required for List interface
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
Ivan Craddock
CSCD 300 Armstrong
Assignment 2

This LinkedList class is a custom version of the Linked List class from the java API.

This class is submitted for 30 points of extra credit in conjunction with the LinkedQueue class.
*/
public class LinkedList implements List<Object> {
	/**
	 * Nested node class
	 */
	protected static class Node {
		Object data;
		Node next;
		Job work;

		/**
		 * EVC for Node
		 * 
		 * @param Object
		 * @param Node
		 * 
		 */
		public Node(Object data, Node next) {
			this.data = data;
			this.next = next;

		}
		// Method not implemented
		// public void removeNext(){
		// Node next = this.next;
		// this.next = next.next;
		// }
		//

		/**
		 * DVC for node without next param
		 * 
		 * @param Object
		 */
		public Node(Object data) {
			this(data, null);
		}

		/**
		 * DVC for node without params
		 */
		public Node() {
			this(null, null);
		}

		/**
		 * Method for determiining if a node is last in the form of a boolean
		 * 
		 * @return boolean
		 */
		public boolean isLast() {
			if (this.next == null)
				return true;
			else
				return false;
		}

		/**
		 * Returns contents of node in the form of a String
		 * 
		 * @return String
		 */
		@Override
		public String toString() {
			return ("" + this.data);
		}

	}

	protected Node head;
	protected int size;
	protected Node tail = new Node(this.head, this.head);

	/**
	 * DVC for LinkedList
	 */
	public LinkedList() {
		this.head = null;
		this.size = 0;
	}

	/**
	 * Returns Node with attributes of tail for use in setting tail
	 * 
	 * @return Node
	 */
	public Node tailMaker() {
		return new Node(this.getLast(), this.head);
	}

	// Method not implemented
	// public Node getHead(){
	// return this.head;
	// }

	// public Node getTail(){
	// return this.tail;
	// }
	//

	/**
	 * Method for adding Nodes to end of LinkedList
	 * 
	 * @param Object
	 * 
	 */
	public void addNode(Object data) {
		Node prime = new Node(data, null);

		if (this.head == null) {
			this.setHead(prime);
		} else {

			if (this.head.isLast() == true) {
				this.head.next = prime;
			} else {
				Node last = this.getLast();
				last.next = prime;
			}

		}
		this.size++;
		this.tail = tailMaker();

	}

	// /**
	// * Method for determining size of LinkedList
	// * @return int
	// */
	// public int getSize(){
	// return this.size;
	//
	// }//end getSize
	/**
	 * Returns last Node in LinkedList
	 * 
	 * @return Node
	 */
	public Node getLast() {
		if (this.head == null) {
			return null;
		}

		Node prime = this.head;

		while (prime.next != null)
			prime = prime.next;

		return prime;
	}

	/**
	 * Returns String of LinkedList contents
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		String s = "";
		if (this.head != null) {
			Node prime = this.head;
			s = (s + prime);
			while (prime.isLast() != true) {
				prime = prime.next;
				s = (s + ", " + prime);
			} // end while
			return s;
		} else
			return s;
	}

	/**
	 * Removes node at the end of the LinkedList
	 */
	public void remove() {
		Node curr = this.head;
		Node last = curr;
		if (this.size != 1) {
			last = last.next;
			while (last.isLast() == false) {
				last = last.next;
				curr = curr.next;
			}
			curr.next = null;
			this.size--;
			this.tail = tailMaker();
		} else {
			this.size = 0;
			setHead(null);
		}
	}

	/**
	 * Method used to change head of LinkedList. Will orphan all data in list if
	 * prime is not a part of the LinkedList
	 * 
	 * @return String
	 */
	public void setHead(Node prime) {// warning will orphan all data in list if
										// prime is not part of list
		this.head = prime;
	}

	// None of the methods below this have been implemented
	@Override
	public boolean add(Object e) {
		throw new UnsupportedOperationException("method not implemented");

	}

	@Override
	public void add(int index, Object element) {
		throw new UnsupportedOperationException("method not implemented");
	}

	@Override
	public boolean addAll(Collection<?> c) {
		throw new UnsupportedOperationException("method not implemented");
	}

	@Override
	public boolean addAll(int index, Collection<?> c) {
		throw new UnsupportedOperationException("method not implemented");
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException("method not implemented");
	}

	@Override
	public boolean contains(Object o) {
		throw new UnsupportedOperationException("method not implemented");
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		throw new UnsupportedOperationException("method not implemented");
	}

	@Override
	public boolean equals(Object o) {
		throw new UnsupportedOperationException("method not implemented");
	}

	@Override
	public Object get(int index) {
		throw new UnsupportedOperationException("method not implemented");
	}

	@Override
	public int hashCode() {
		throw new UnsupportedOperationException("method not implemented");
	}

	@Override
	public int indexOf(Object o) {
		throw new UnsupportedOperationException("method not implemented");
	}

	@Override
	public boolean isEmpty() {
		throw new UnsupportedOperationException("method not implemented");
	}

	@Override
	public Iterator<Object> iterator() {
		throw new UnsupportedOperationException("method not implemented");
	}

	@Override
	public int lastIndexOf(Object o) {
		throw new UnsupportedOperationException("method not implemented");
	}

	@Override
	public ListIterator<Object> listIterator() {
		throw new UnsupportedOperationException("method not implemented");
	}

	@Override
	public ListIterator<Object> listIterator(int index) {
		throw new UnsupportedOperationException("method not implemented");
	}

	@Override
	public Object remove(int index) {
		throw new UnsupportedOperationException("method not implemented");
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException("method not implemented");
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException("method not implemented");
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException("method not implemented");
	}

	@Override
	public Object set(int index, Object element) {
		throw new UnsupportedOperationException("method not implemented");
	}

	@Override
	public int size() {
		throw new UnsupportedOperationException("method not implemented");
	}

	@Override
	public List<Object> subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException("method not implemented");
	}

	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException("method not implemented");
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] toArray(Object[] a) {
		throw new UnsupportedOperationException("method not implemented");
	}

}