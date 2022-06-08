
class BinarySearchTree {
	class Node {
		static int count = 0;
		String data;
		Node left, right;
		// constructor that takes string parameter
		public Node(String in) {
			data = in;
			left = right = null;
		}
	}
	
	Node root;
	// default constructor for tree
	BinarySearchTree() {
		root = null;
	}

	void newInsert(String data) {
		root = insert(root, data);
	}

	Node insert(Node root, String in) {
		// if tree is empty, add to root
		if (root == null) {
			root = new Node(in);
			return root;
		}
		// if root data is "greater" than parameter
		if (in.compareTo(root.data) < 0) {
			// recursive call on element to the left
			root.left = insert(root.left, in);
		}
		// if root data is "less" than parameter
		else if (in.compareTo(root.data) > 0) {
			// recursive call on element to the right
			root.right = insert(root.right, in);
		}
		return root;
	}

	void display(Node root) {
		Node temp = root;
		if (temp == null)
			return;
		// use recursion to display tree
		display(temp.left);
		System.out.print("[" + temp.data + "] ");
		display(temp.right);

	}

	boolean search(String in) {
		// set count to 0 to keep track of how many elements are inspected
		root.count = 0;
		Node temp = searchRecursive(root, in);
		if (temp != null)
			return true;
		return false;
	}

	Node searchRecursive(Node root, String in) {
		// if root is equal to parameter or null
		if (root == null || root.data.equals(in)) {
			return root;
		}
		// if root data is "greater" than parameter
		// call search on the element to the left
		if (root.data.compareTo(in) > 0) {
			// update count
			root.count+=1;
			return searchRecursive(root.left, in);
		}
		// update count
		root.count +=1;
		// call search on the element to the right
		return searchRecursive(root.right, in);
	}

	String minValue(Node root) {
		String minval = root.data;
		// find leftmost element in the tree
		while (root.left != null) {
			minval = root.left.data;
			root = root.left;
		}
		return minval;
	}

	void deleteKey(String in) {
		root = deleteRecursive(root, in);
	}

	Node deleteRecursive(Node root, String in) {
		if (root == null)
			return root;
		// if root data is "greater" than parameter
		if (in.compareTo(root.data) < 0) {
			// recursive call on element to the left
			root.left = deleteRecursive(root.left, in);
		} 
		// if root data is "less" than parameter
		else if (in.compareTo(root.data) > 0) {
			// recursive call on element to the right
			root.right = deleteRecursive(root.right, in);
		} else {
			// if root doesn't have a child to the left
			if (root.left == null) {
				return root.right;
			} 
			// if root doesn't have a child to the right
			else if (root.right == null) {
				return root.left;
			}
			// set root data to min value
			root.data = minValue(root.right);
			// delete root to the right
			root.right = deleteRecursive(root.right, root.data);
		}
		return root;
	}

}
