import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// create graph
		Graph myGraph = new Graph();
		myGraph.display();
		Scanner myScanner = new Scanner(System.in);
		// string array with all cities
		String[] places = { "Mohave", "Coconino", "Navajo", "Apache", "Greenlee", "Cochise", "Santa Cruz", "Pima",
				"Pinal", "Graham", "Gila", "Yavapai", "La Paz", "Yuma", "Maricopa" };
		
		System.out.println("Type the name of the city you want to start from: ");
		String c1 = myScanner.next();
		System.out.println("Type the name of the city you want to go to: ");
		String c2 = myScanner.next();
		
		int i,j = 0;
		// find index for both cities by looping through array
		for(i = 0; i < 14; i++) {
			if ( places[i].equals(c1)) {
				break;
			}
		}
		for(j = 0; j < 14; j++) {
			if ( places[j].equals(c2)) {
				break;
			}
		}
		System.out.println("The distance between " + places[i] + " and " + places[j] + " is " + myGraph.getDistance(i,j));
		
		System.out.println("Type the name of a city to see its neighbours: ");
		String c3 = myScanner.next();
		
		myGraph.getNeighbors(c3,places);
		
	}

}
