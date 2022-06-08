
class HashTable {
	// create const int for size
	static final int SIZE = 11;

	class Node {
		String data;
		Node next;

		// constructor for node that takes string parameter
		public Node(String in) {
			data = in;
			next = null;
		}
		
	}
	Node[] bucketArray = new Node[SIZE];
	
	public void insert(String in) {
		Node newNode = new Node(in);
		newNode.next = bucketArray[hashed(in)];
		bucketArray[hashed(in) % SIZE] = newNode;
	}

	static int hashed(String in) {
		int x = 0;
		// return sum of all ASCII values
		for (int i = 0; i < in.length(); i++) {
			x += in.charAt(i);
		}
		return x % SIZE;
	}

	boolean find(String in) {
		// int to count how many words were inspected
		int count = 1;
		// hash the word we're looking for
		int h = hashed(in);
		// create temp array with hash value
		Node temp = bucketArray[h];
		if (temp == null)
			return false;
		if (bucketArray[h].data.equals(in)) {
			System.out.println("1 element inspected");
			return true;
		} else if (bucketArray[h] != null) {
			// loop through linked list
			while (temp != null) {
				count++;
				// compare node data to input
				if (temp.data.equals(in)) {
					System.out.println(count + " elements inspected");
					return true;
				}
				temp = temp.next;
			}
		}
		System.out.println(count + " elements inspected");
		return false;

	}

	public void display() {
		Node temp;
		// loop through bucket array
		for (int i = 0; i < SIZE; i++) {
			temp = bucketArray[i];
			while (temp != null) {
				System.out.print("{" + temp.data + "} ");
				temp = temp.next;
			}
		}
		System.out.println();
	}

}
