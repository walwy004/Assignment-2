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
		if (head == null || index < 0 || index >= size()) {
			return null;
		}
		
		Node current = head;
		int count = 0;
		
		while (count < index) {
			current = current.next;
			count++;
		}
		
		// Removing head
		if (current == head) {
			head = head.next;
			if (head != null) {
				head.prev = null;
			} else {
				tail = null;	// list is now empty
			}
		}
		// Removing tail
		else if (current == tail) {
			tail = tail.prev;
			if (tail != null) {
				tail.next = null;
			}
		}
		// Removing in the middle
		else {
			current.prev.next = current.next;
			current.next.prev = current.prev;
		}
		
		return current.getString();
	}

	//returns the index of the String parameter 
	public int indexOf(String obj) {
		if (obj == null) return -1;
		
		Node current = head;
		int index = 0;
		
		while (current != null) {
			if (obj.equals(current.getString())) {
				return index;
			}
			current = current.next;
			index++;
		}
		
		return -1; // not found
	}
	
	//returns String at parameter's index
	public String get(int index) {
		if (index < 0) return null;
		
		Node current = head;
		int count = 0;
		
		while (current != null) {
			if (count == index) {
				return current.getString();
			}
			current = current.next;
			count++;
		}
		
		return null; // index out of bounds
	}

	//checks if there is a list
	public boolean isEmpty() {
		return head == null;
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
		if (head == null) return "";
		
		StringBuilder sb = new StringBuilder();
		Node current = head;
		
		while (current != null) {
			sb.append(current.getString());
			if (current.next != null) {
				sb.append(" ");
			}
			current = current.next;
		}
		
		return sb.toString();
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
		if (obj == null || index < 0 || index > size()) {
			return false;
		}
		
		Node newNode = new Node(null, null, obj);
		
		// Case 1: Insert at front
		if (index == 0) {
			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				newNode.next = head;
				head.prev = newNode;
				head = newNode;
			}
			
			return true;
		}
		
		// Case 2: Insert at end
		if (index == size()) {
			return add(obj);	// use existing add method
		}
		
		// Case 3: Insert in the middle
		Node current = head;
		int count = 0;
		
		while (count < index - 1) {
			current = current.next;
			count++;
		}
		
		Node after = current.next;
		
		current.next = newNode;
		newNode.prev = current;
		newNode.next = after;
		if (after != null) {
			after.prev = newNode;
		}
		
		return true;
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
