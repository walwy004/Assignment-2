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
	public T remove(int index) {
		if (head == null || index < 0 || index >= size()) {
			return null;
		}
		
		NodeGeneric<T> current = head;
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
		
		return current.get();
	}

	//returns the index of the String parameter 
	public int indexOf(T obj) {
		if (obj == null) return -1;
		
		NodeGeneric<T> current = head;
		int index = 0;
		
		while (current != null) {
			if (obj.equals(current.get())) {
				return index;
			}
			current = current.next;
			index++;
		}
		
		return -1; // not found
	}
	
	//returns item at parameter's index
	public T get(int index) {
		if (index < 0) return null;
		
		NodeGeneric<T> current = head;
		int count = 0;
		
		while (current != null) {
			if (count == index) {
				return current.get();
			}
			current = current.next;
			count++;
		}
		
		return null;	// index out of bounds
	}

	//checks if there is a list
	public boolean isEmpty() {
		return head == null;
	}

	//return the size of the list
	public int size() {
		int count = 0;
		NodeGeneric<T> current = head;
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
		NodeGeneric<T> current = head;
		
		while (current != null) {
			sb.append(current.get());
			if (current.next != null) {
				sb.append(" ");
			}
			current = current.next;
		}
		
		return sb.toString();
	}

	//add the parameter item at of the end of the list
	public boolean add(T obj) {
		if (obj == null) return false;
		
		NodeGeneric<T> newNode = new NodeGeneric<>(null, null, obj);
		
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

	//add item at parameter's index
	public boolean add(int index, T obj) {
		if (obj == null || index < 0 || index > size()) {
			return false;
		}
		
		NodeGeneric<T> newNode = new NodeGeneric<>(null, null, obj);
		
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
		NodeGeneric<T> current = head;
		int count = 0;
		
		while (count < index - 1) {
			current = current.next;
			count++;
		}
		
		NodeGeneric<T> after = current.next;
		
		current.next = newNode;
		newNode.prev = current;
		newNode.next = after;
		if (after != null) {
			after.prev = newNode;
		}
		
		return true;
	}

	//searches list for parameter's String return true if found
	public boolean contains(T obj) {
		if (obj == null) return false;
		
		NodeGeneric<T> current = head;
		
		while (current != null) {
			if (obj.equals(current.get())) {
				return true;
			}
			current = current.next;
		}
		
		return false;
	}

	//removes the parameter's item form the list
	public boolean remove(T obj) {
		if (obj == null || head == null) return false;
		
		NodeGeneric<T> current = head;
		
		while (current != null) {
			if (obj.equals(current.get())) {
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
				// Removing from middle
				else {
					current.prev.next = current.next;
					current.next.prev = current.prev;
				}
				
				return true;
			}
			
			current = current.next;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) return true;
		if (other == null || !(other instanceof DSEListGeneric)) return false;
		
		DSEListGeneric<?> otherList = (DSEListGeneric<?>) other;
		
		NodeGeneric<T> currA = this.head;
		NodeGeneric<?> currB = otherList.head;
		
		while (currA != null && currB != null) {
			if (!currA.get().equals(currB.get())) {
				return false;
			}
			currA = currA.next;
			currB = currB.next;
		}
		
		return currA == null && currB == null;
	}
	
}
