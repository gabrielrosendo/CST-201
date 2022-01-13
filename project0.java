/*
 * Gabriel Marcelino
 * CST-201
 * January 12, 2022
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class project0 {

	public static void main(String[] args) throws IOException {
		File myObj = new File("input.txt");
		// read input file
		Scanner myReader = new Scanner(myObj);
		String[] strArr = new String[10000];
		// create string array with words from the file
		int cur = 0;
		while(myReader.hasNext()) {
			String str = myReader.next();
			strArr[cur] = str;
			cur++;
		}
		// print out unsorted array
		System.out.println("Unsorted Array...");
		for(int j = 0; j < strArr.length && strArr[j] != null; j++) {
			System.out.printf(strArr[j] + "    ");
		}
		
		System.out.println("");
		System.out.println("Sorted array...");
		
		String temp;
		for (int j = 0; j < strArr.length && strArr[j] != null; j++) {
			for (int i = j + 1; i < strArr.length && strArr[i] != null; i++) {
				if (strArr[i].compareTo(strArr[j]) < 0) {
					temp = strArr[j];
					strArr[j] = strArr[i];
					strArr[i] = temp;
				}
			}
			System.out.printf(strArr[j] + "    ");
		}
		System.out.println();
		
		boolean found = false;
		boolean end = false;
		int index = 0;
		do {
			Scanner usin = new Scanner(System.in);
			System.out.println("Enter words to search for... enter 0 to quit");
			String word = usin.next();
			if (word.equals("0")) {
				System.out.println("Goodbye");
				end = true;
				return;
				
			}
			else {
				for (int j = 0; j < strArr.length; j++) {
					if (word.equals(strArr[j])) {
						found = true;
						index = j;
					}
				}
				if (found) {
					System.out.println(word + " is in the list at index " + index);
				}
				else {
					System.out.println(word + " is not in the list");
				}
				
			}	

		}
		while(end = true);
		
		myReader.close();
		
		
		
		
	}

}
