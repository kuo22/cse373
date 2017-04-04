// Kuo Hong
// Section AF

// This program simulates a queue ADT that allows the user to enqueue string
// data and dequeue them in a first in, first out order. It will also allow
// the user to look at the data in front of the queue before dequeuing it.
public class ListQueue {
	private Node current; // Node of the front of the queue
	
	private class Node{
		private String data; // The string data that the node contains
		private Node next; // The node next to the current node
		
		// Constructs a node containing the given string data
		private Node(String data) {
			this.data = data;
		}
	}
	
	// Constructs an empty queue
	public ListQueue(){
		this.current = new Node(null);
	}
	
	// Adds a new node containing the given string of input to the last place
	// in the queue
	public void enqueue(String toInput) {
		if (this.current.data == null) {
			this.current.data = toInput;
		} else {
			Node temp = this.current;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(toInput);
		}
	}
	
	// Removes the node in front of the queue and returns a string of the data
	// it contains. Returns null if the queue is empty
	public String dequeue(){
		if (this.current.data != null) {
			String temp = this.current.data;
			if (this.current.next == null)
				this.current.data = null;
			else
				this.current = this.current.next;
			return temp;
		}
		return null;
	}
	
	// Returns a string of the data contained by the node in front of the queue
	public String front(){
		return this.current.data;
	}
}
