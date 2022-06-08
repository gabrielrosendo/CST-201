
class Graph {
	static int[][] TwoArray;

	public Graph() {
		TwoArray = new int[15][15];

		// input data
		TwoArray[0][1] = 14;
		TwoArray[0][11] = 14;
		TwoArray[0][12] = 9;

		TwoArray[1][0] = 14;
		TwoArray[1][11] = 9;
		TwoArray[1][2] = 9;
		TwoArray[1][10] = 17;

		TwoArray[2][1] = 9;
		TwoArray[2][10] = 13;
		TwoArray[2][9] = 20;
		TwoArray[2][3] = 5;

		TwoArray[3][2] = 5;
		TwoArray[3][9] = 19;
		TwoArray[3][4] = 17;

		TwoArray[4][3] = 17;
		TwoArray[4][9] = 4;
		TwoArray[4][5] = 16;

		TwoArray[5][4] = 16;
		TwoArray[5][9] = 12;
		TwoArray[5][7] = 9;
		TwoArray[5][6] = 8;

		TwoArray[6][5] = 8;
		TwoArray[6][7] = 6;

		TwoArray[7][6] = 6;
		TwoArray[7][5] = 9;
		TwoArray[7][9] = 12;
		TwoArray[7][8] = 7;
		TwoArray[7][14] = 10;
		TwoArray[7][13] = 23;

		TwoArray[8][10] = 5;
		TwoArray[8][9] = 13;
		TwoArray[8][14] = 6;
		TwoArray[8][7] = 7;

		TwoArray[9][2] = 20;
		TwoArray[9][3] = 19;
		TwoArray[9][4] = 4;
		TwoArray[9][5] = 12;
		TwoArray[9][7] = 12;
		TwoArray[9][8] = 13;
		TwoArray[9][10] = 7;

		TwoArray[10][1] = 17;
		TwoArray[10][2] = 13;
		TwoArray[10][9] = 7;
		TwoArray[10][8] = 5;
		TwoArray[10][14] = 8;
		TwoArray[10][11] = 18;

		TwoArray[11][0] = 14;
		TwoArray[11][1] = 9;
		TwoArray[11][10] = 18;
		TwoArray[11][14] = 9;
		TwoArray[11][12] = 15;

		TwoArray[12][0] = 9;
		TwoArray[12][11] = 15;
		TwoArray[12][14] = 15;
		TwoArray[12][13] = 11;

		TwoArray[13][7] = 23;
		TwoArray[13][14] = 18;
		TwoArray[13][12] = 11;

		TwoArray[14][7] = 10;
		TwoArray[14][8] = 6;
		TwoArray[14][10] = 8;
		TwoArray[14][11] = 9;
		TwoArray[14][12] = 15;
		TwoArray[14][13] = 18;
	}

	void display() {
		// display whole graph
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				System.out.print(TwoArray[i][j] + " ");
			}
			System.out.println();
		}
	}

	void getNeighbors(String str, String[] arr) {
		int z;
		System.out.println(str + " neighbours are: ");
		for(z = 0; z < 14; z++) {
			// loop through array until city is found
			if ( arr[z].equals(str)) {
				break;
			}
		}
		for (int i = 0; i < 15; i++) {
			// use index z found to get all neighbors
			if (TwoArray[z][i] > 0) {
				System.out.println(arr[i]);
			}
		}
	}
	
	int getDistance(int start, int end) {
		int m = end;
		int total = 0;
		// if the cities are neighbors, return distance between them
		if(TwoArray[start][m] > 0) {
			System.out.println(TwoArray[start][m]);
			return TwoArray[start][m];
		}
		// loop until a path is found
		while (TwoArray[start][m] == 0) {
			m-=1;
			if (TwoArray[start][m] == 0) {
				m+=1;
			}
			total += TwoArray[start][m];
			start = m;
			m = end;
			if (TwoArray[start][m] > 0) {
				total += TwoArray[start][end];
			}
		}
		System.out.println(total);
		// return total distance
		return total;
	}

}
