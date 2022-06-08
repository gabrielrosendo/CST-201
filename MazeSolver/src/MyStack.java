
public class MyStack<T> {
	public class Node {
		T data;
		Node next;

		public Node(T data) {
			this.data = data;
			next = null;
		}

		public Node(Node node) {
			data = node.data;
			 if (node.next == null) {
				next = null;
			} else {
				next = new Node(node.next);
			}
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public void setValue(T value) {
			data = value;
		}

		public T getValue() {
			return data;
		}

		public Node getNext() {
			return next;
		}

		public boolean hasNext() {
			return next != null;
		}
	}

	Node head;
	Node tail;
	int nodeCount;

	public MyStack() {
		nodeCount = 0;
		head = null;
		tail = null;
	}

	// copy constructor for listO(n)
	public MyStack(MyStack<T> input) {
		nodeCount = input.nodeCount;
		head = new Node(input.head);
		tail = new Node(input.tail);
	}

	public boolean empty() {
		return head == null;
	}

	public void push(T element) {

		nodeCount++;
		Node node = new Node(element);
		// set node to head
		node.setNext(head);
		head = node;
	}

	public T pop() {
		if (head == null)
			return null;
		nodeCount--;
		T output = head.getValue();
		head = head.getNext();
		return output;
	}

	public T top() {
		return head.getValue();
	}

	public int size() {
		return nodeCount;
	}

	@Override
	public String toString() {
		return "MyStack [head=" + head.getValue() + ", tail=" + tail + ", nodeCount=" + nodeCount + "]";
	}
	
	public void display() {
		String[] arr = new String[nodeCount];
		System.out.println("Your path is: ");
		for (int i = 0; i < nodeCount; i++) {
			arr[i] = head.getValue().toString();
			head = head.next;
		}
		for (int j = nodeCount-1; j > 0; j--) {
			System.out.println(arr[j]);
		}
	}

}
