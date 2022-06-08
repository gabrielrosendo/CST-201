
/**
 * provided file for DLinkedList Assignment
 *
 * @author lkfritz
 */

public class DLinkedList<T extends Comparable<T>> {

	// inner DNode class: PROVIDED
	private class DNode {
		private DNode next, prev;
		private T data;

		private DNode(T val) {
			this.data = val;
			next = prev = this;
		}
	}

	// DLinkedList fields: PROVIDED
	private DNode header;

	// create an empty list: PROVIDED
	public DLinkedList() {
		header = new DNode(null);
	}

	/**
	 * PROVIDED add
	 *
	 * @param item return ref to newly inserted node
	 */
	public DNode add(T item) {
		// make a new node
		DNode newNode = new DNode(item);
		// update newNode
		newNode.prev = header;
		newNode.next = header.next;
		// update surrounding nodes
		header.next.prev = newNode;
		header.next = newNode;
		return newNode;
	}

	// PROVIDED
	public String toString() {
		String str = "[";
		DNode curr = header.next;
		if (curr != null) {
			while (curr.data != header.data) {
				if (curr.next.data == null) {
					str += curr.data;
					break;
				}
				str += curr.data + ", ";
				curr = curr.next;
			}
			str = str.substring(0, str.length());
		}
		return str + "]";
	}

	/**
	 * ASSIGNED remove val from the list
	 *
	 * @param val
	 * @return true if successful, false otherwise
	 */
	public boolean remove(T val) {
		DNode curr = header.next;
		DNode prev = null;
		DNode next = null;
		while (curr.next != null) {
			if (curr.data.equals(val)) {
				prev.next = next;
				next.prev = prev;
				return true;
			}
			prev = curr;
			curr = curr.next;
			next = curr.next;
		}
		// data not found
		return false;
	}

	/**
	 * ASSIGNED
	 *
	 * @param item
	 */
	public void insertOrder(T item) {
		add(item);
		// Sort the list after inserting the one element
		DNode current = null, index = null;
		T tempItem;
		// Check whether list is empty
		if (header.next.data == null) {
			return;
		} else {
			// Current will point to head
			for (current = header.next; current.next != null && current.data != null; current = current.next) {
				// Index will point to node next to current
				for (index = current.next; index != null && index.data != null; index = index.next) {
					// If current's data is greater than index's data, swap the data of current and
					// index
					if (current.data.compareTo(index.data) > 0) {
						tempItem = current.data;
						current.data = index.data;
						index.data = tempItem;
					}

				}
			}
		}
	}

	/**
	 * ASSIGNED
	 *
	 * @param item
	 */
	public boolean insertOrderUnique(T item) {
		DNode curr = header;
		while (curr.next.data != null) {
			if (curr.next.data.equals(item)) {
				// data is already in the list
				return false;
			}
			curr = curr.next;
		}
		insertOrder(item);
		return true;
	}

	/**
	 * ASSIGNED PRE: this and rhs are sorted lists
	 * 
	 * @param rhs
	 * @return list that contains this and rhs merged into a sorted list POST:
	 *         returned list will not contain duplicates
	 */
	public DLinkedList merge(DLinkedList rhs) {
		DLinkedList result = new DLinkedList();
		// variable to point the last node of the list.
		DNode p = result.header;
		DNode l1 = header.next;
		DNode prev = header.prev;
		DNode l2 = rhs.header.next;
		// Iterate through lists
		while (l1.data != null && l2.data != null) {
			// Find the smaller element and append it to the list.
			if (l1.data.compareTo(l2.data) < 0) {
				p.next = l1;
				p.prev = prev;
				l1 = l1.next;
			}
			// if data is equal, just write it once
			else if (l1.data.compareTo(l2.data) == 0) {
				p.next = l1;
				p.prev = prev;
				l1 = l1.next;
				l2 = l2.next;
			} else {
				p.next = l2;
				p.prev = prev;
				l2 = l2.next;
			}
			prev = p;
			p = p.next;
		}
		// check which list still has elements
		if (l1.data == null) 
			p.next = l2;
		 else if (l2.data == null) 
			p.next = l1;
		// delete lists
		header.next = null;
		rhs.header.next = null;
		return result;
	}

}