import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner fin = new Scanner(new File("in.txt"));
		Scanner myObj = new Scanner(System.in);
		// create Hash Table
		HashTable table = new HashTable();
		// read txt file and insert words to table
		while (fin.hasNext()) {
			table.insert(cleanUp(fin.next()));
		}
		table.display();
		String str = "";
		while (str != "-1") {
			// ask user for word to look for
			System.out.print("Enter a word to search for(-1 to quit): ");
			str = myObj.next();
			if (str.equals("-1"))
				break;
			if (table.find(str))
				System.out.println("Word found");
			else
				System.out.println("Word not found");
		}
	}

	public static String cleanUp(String str) {
		str = str.replaceAll("[^a-zA-Z0-9']", "");
		str = str.toLowerCase();
		return str;
	}

}
