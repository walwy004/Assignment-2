package unisa.dse.a2.students;

import unisa.dse.a2.interfaces.List;

/**
 * @author simont
 *
 */
public class DSEList implements List {
	
	public Node head;
	private Node tail;

	public DSEList() {
		head = null;
		tail = null;
	}
	
	public DSEList(Node head_) {
		this.head = head_;
		this.tail = head_;
	}
	
	//Takes a list then adds each element into a new list
	public DSEList(DSEList other) { // Copy constructor. 
		if (other.head == null) {
			head = null;
			tail = null;
			return;
		}
		
		Node current = other.head;
		head = new Node(null, null, current.getString());
		Node newCurrent = head;
		
		while (current.next != null) {
			current = current.next;
			Node newNode = new Node(null, newCurrent, current.getString());
			newCurrent.next = newNode;
			newCurrent = newNode;
		}
		
		tail = newCurrent;
	}

	//remove the String at the parameter's index
	public String remove(int index) {

	}

	//returns the index of the String parameter 
	public int indexOf(String obj) {
	}
	
	//returns String at parameter's index
	public String get(int index) {
	}

	//checks if there is a list
	public boolean isEmpty() {
	}

	//return the size of the list
	public int size() {
		int count = 0;
		Node current = head;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}
	
	//Take each element of the list a writes them to a string 
	@Override
	public String toString() {
	}

	//add the parameter String at of the end of the list
	public boolean add(String obj) {
		if (obj == null) return false;
		
		Node newNode = new Node(null, null, obj);
		
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		
		return true;
	}

	//add String at parameter's index
	public boolean add(int index, String obj) {
	}

	//searches list for parameter's String return true if found
	public boolean contains(String obj) {
	}

	//removes the parameter's String form the list
	public boolean remove(String obj) {
	}
	
	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object other) {
		return true;
	}
	
}
