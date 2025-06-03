package unisa.dse.a2.students;

import unisa.dse.a2.interfaces.ListGeneric;

/**
 * @author simont
 *
 */
public class DSEListGeneric<T> implements ListGeneric<T> {
	
	public NodeGeneric<T> head;
	private NodeGeneric<T> tail;

	public DSEListGeneric() {
		head = null;
		tail = null;
	}
	
	public DSEListGeneric(NodeGeneric<T> head_) {
		this.head = head_;
		this.tail = head_;
	}
	
	//Takes a list then adds each element into a new list
	public DSEListGeneric(DSEListGeneric<T> other) { // Copy constructor. 
		if (other.head == null) {
			head = null;
			tail = null;
			return;
		}
		
		NodeGeneric<T> current = other.head;
		head = new NodeGeneric<>(null, null, current.get());
		NodeGeneric<T> newCurrent = head;
		
		while (current.next != null) {
			current = current.next;
			NodeGeneric<T> newNode = new NodeGeneric<>(null, newCurrent, current.get());
			newCurrent.next = newNode;
			newCurrent = newNode;
		}
		
		tail = newCurrent;
	}

	//remove and return the item at the parameter's index
	public void remove(int index) {

	}

	//returns the index of the String parameter 
	public int indexOf(String obj) {
	}
	
	//returns item at parameter's index
	public void get(int index) {
	}

	//checks if there is a list
	public boolean isEmpty() {
	}

	//return the size of the list
	public int size() {
	}
	
	//Take each element of the list a writes them to a string 
	@Override
	public String toString() {
	}

	//add the parameter item at of the end of the list
	public boolean add(Object obj) {
	}

	//add item at parameter's index
	public boolean add(int index, Object obj) {
	}

	//searches list for parameter's String return true if found
	public boolean contains(Object obj) {
	}

	//removes the parameter's item form the list
	public boolean remove(Object obj) {
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
