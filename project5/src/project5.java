import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class project5 {
	static boolean isSlip(String str) {
		// if first character is not a 'D' or an 'E', return false
		if (str.charAt(0) != 'D' && str.charAt(0) != 'E') {
			return false;
		}
		// if length is 1, return false 
		if (str.length() == 1) {
			return false;
		}
		// check if second character is a 'F'
		if (str.charAt(1) == 'F') {
			// if it is, loop for however many F there are
			for (int i = 2; i < str.length(); i++) {
				if (str.charAt(i) == 'F') {
					continue;
				}
				// if there is a 'G' after the F's, break the loop
				else if (str.charAt(i) == 'G') {
					break;
				}
				// if there is a 'D' or an 'E' after the F's, check for slip 
				else if (str.charAt(i) == 'D' || str.charAt(i) == 'E') {
					return isSlip(str.substring(i));
				} else
					return false;
			}
		} else
			return false;
		// if last character is not a 'G', return false
		if (str.charAt(str.length() - 1) != 'G') {
			return false;
		}
		return true;
	}

	static boolean isSlap(String str) {
		// if first character is not an 'A', return false
		if (str.charAt(0) != 'A') {
			return false;
		}
		// if length is 1, return false
		if (str.length() == 1) {
			return false;
		}
		// if length is 2, return true only if second character is 'H'
		if (str.length() == 2) {
			return (str.charAt(1) == 'H');
		} else {
			if (str.charAt(1) == 'B') {
				String subStr = str.substring(2, str.length() - 1);
				// check if the substring after the B is a slap
				if (subStr.length() > 1) {
					if (isSlap(subStr)) {
						// check if last character is a 'C'
						if (str.charAt(str.length() - 1) == 'C') {
							return true;
						}
					}
				}
			}
			// check if the A is followed by a slip
			if (isSlip(str.substring(1, str.length() - 1))) {
				// check if last character is a 'C'				
				if (str.charAt(str.length() - 1) == 'C') {
					return true;
				}
				return false;
			} else
				return false;
		}

	}

	static boolean isSlop(String str) {
		int i = 0;
		int len = str.length();
		while (i < len - 3) {
			// check for slap
			if (isSlap(str.substring(0, i + 1))) {
				// check if there is a slip after the slap
				if (isSlip(str.substring(i + 1))) {
					return true;
				}
			}
			i++;
		}
		return false;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner fin = new Scanner(new File("src/txt.in"));
		int num = fin.nextInt();
		System.out.println("SLOPS OUTPUT");
		for (int i = 0 ; i < num ; i++) {
			String str = fin.next();
			 if (isSlop(str)) {
				 System.out.println("YES");
			 }
			 else 
				 System.out.println("NO");
		}
		System.out.println("END OF OUTPUT");
		
	}

}
