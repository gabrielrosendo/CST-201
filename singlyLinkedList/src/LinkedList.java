
// create class
public class LinkedList {
	public Node head;

	// default constructor
	class Node {
		int data;
		public Node next;

		Node(int i) {
			this.data = i;
			this.next = null;
		}

		public Node() {
			this.next = null;
		}
	}

	// access first element of the list
	public Node front() {
		// if list is not empty, return first element
		if (head != null) {
			return head;
		}
		// else, return null
		return null;
	}

	// access last element of the list
	public Node back() {
		Node newNode = head;
		while (newNode.next != null) {
			newNode = newNode.next;
		}
		return newNode;
	}

	// insert element in order
	public void insert(int data) {
		Node current;
		Node new_node = new Node(data);

		if (head == null || head.data >= new_node.data) {
			new_node.next = head;
			head = new_node;
		} else {
			current = head;

			while (current.next != null && current.next.data < new_node.data) {
				current = current.next;
			}
			new_node.next = current.next;
			current.next = new_node;
		}
	}

	// delete first element
	void pop_front() {
		if (head != null) {
			head = head.next;
		}
	}

	// delete last element
	void pop_back() {
		Node newNode = head;
		Node prev = null;
		while (newNode.next != null) {
			prev = newNode;
			newNode = newNode.next;
		}
		prev.next = null;

	}

	// determine if empty
	public boolean empty() {
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}

	// determine size of linked list
	public int size() {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	// reverse linked list
	public void reverse() {
		Node prev = null;
		Node curr = head;
		Node next = head;
		// loop through list
		while (curr != null) {
			next = next.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		// set head to last element of list
		head = prev;
	}

	// merge in order with another linked list
	LinkedList merge(LinkedList myList) {
		// New List
		LinkedList result = new LinkedList();
		result.head = new Node();
		// variable to point the last node of the list.
		Node p = result.head;
		Node l1 = head;
		Node l2 = myList.head;
		// Iterate the loop
		while (l1 != null && l2 != null) {
			// Find the smaller element and append it to the
			// list.
			if (l1.data < l2.data) {
				p.next = l1;
				l1 = l1.next;
			} else if (l1.data == l2.data) {
				p.next = l1;
				l1 = l1.next;
				l2 = l2.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		if (l1 == null) {
			p.next = l2;
		}

		else if (l2 == null) {
			p.next = l1;
		}
		result.pop_front();
		return result;
	}

	// print all elements in linked list
	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

}
