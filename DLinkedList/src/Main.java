import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		DLinkedList<String> lst1 = new DLinkedList<>();
		DLinkedList<String> lst2 = new DLinkedList<>();

		Scanner fin = new Scanner(new File("text1.in"));
		String str;

		while (fin.hasNext()) {
			str = fin.next();
			str = cleanUp(str);
			lst1.insertOrderUnique(str);
		}
		fin.close();
		
		str = "";
		fin = new Scanner(new File("text2.in"));
		while (fin.hasNext()) {
			str = fin.next();
			str = cleanUp(str);
			lst2.insertOrderUnique(str);
		}

		System.out.println("List 1:  " + lst1);
		System.out.println("List 2:  " + lst2);

		DLinkedList combined = lst1.merge(lst2);

		System.out.println("\nAFTER MERGE");
		System.out.println("List 1:  " + lst1);
		System.out.println("List 2:  " + lst2);
		System.out.println("\n" + combined);
	}
	
	/**
	 * ASSIGNED
	 * 
	 * @param str
	 * @return str in all lower case with LEADING and TRAILING non-alpha chars
	 *         removed
	 */
	public static String cleanUp(String str) {
		str = str.replaceAll("[^a-zA-Z0-9']", "");
		str = str.toLowerCase();
		return str;
	}
}