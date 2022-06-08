import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		BinarySearchTree l1 = new BinarySearchTree();
		// create scanner to read txt file
		Scanner fin = new Scanner(new File("txt.in"));
		while (fin.hasNext()) {
			// insert every word in file to tree
			l1.newInsert(cleanUp(fin.next()));
		}
		// display tree
		l1.display(l1.root);
		System.out.println();
		String str = "";
		Scanner myObj = new Scanner(System.in);
		while (str != "-1") {
			// ask user for input
			System.out.println("Enter string, enter -1 to quit: ");
			str = myObj.next();
			if (str.equals("-1")) 
				break;
			else if (l1.search(str)) {
				// if string was located in the tree
				System.out.println("Inspected " + l1.root.count + " elements");
				System.out.println(str + " located");
			}
			else {
				System.out.println("Inspected " + l1.root.count + " elements");
				System.out.println(str + " not located");
			}
		}
		str = "";
		while (str != "-1") {
			// ask user for string to remove
			System.out.println("Enter strings to remove: ");
			str = myObj.next();
			if (str.equals("-1"))
					break;
			// delete string from tree and display tree
			l1.deleteKey(str);
			l1.display(l1.root);
			System.out.println();
		}
	}
	
	public static String cleanUp(String str) {
		str = str.replaceAll("[^a-zA-Z0-9']", "");
		str = str.toLowerCase();
		return str;
	}

}
