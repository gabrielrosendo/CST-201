import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//starter code for MazeSolver
//CST-201

public class Driver {

	/**
	 * 
	 * @param start
	 * @param end   find a path through the maze if found, output the path from
	 *              start to end if not path exists, output a message stating so
	 * 
	 */
	// implement this method
	public static void depthFirst(MazeCell[][] cells, MazeCell start, MazeCell end) {
		// create stack to
		MyStack<MazeCell> stack = new MyStack<MazeCell>();
		int i = start.getRow(); 
		int j = start.getCol();
		// push start of the maze to stack
		stack.push(cells[i][j]);
		// while not at the end of the maze
		while (cells[i][j] != cells[end.getRow()][end.getCol()]) {
			// check if out of bounds and if visited
			if (j + 1 <= 5 && cells[i][j + 1].unVisited()) {
				// go right
				if (cells[i][j].getCol() <= 5 && cells[i][j + 1].getRow() != -1) {
					cells[i][j + 1].visit();
					stack.push(cells[i][j + 1]);
					j++;
				}
			}
			// go up
			else if (cells[i][j].getCol() <= 0 && cells[i - 1][j].getRow() != -1 && cells[i - 1][j].unVisited()) {
				cells[i - 1][j].visit();
				stack.push(cells[i - 1][j]);
				i--;
			} 
			// go left
			else if (cells[i][j].getCol() <= 5 && cells[i][j - 1].getRow() != -1 && cells[i][j - 1].unVisited()) {
				cells[i][j - 1].visit();
				stack.push(cells[i][j - 1]);
				j--;
			}
			// go down
			else if (cells[i][j].getCol() <= 5 && cells[i + 1][j].getRow() != -1 && cells[i + 1][j].unVisited()) {
				cells[i + 1][j].visit();
				stack.push(cells[i + 1][j]);
				i++;
			} 
			// if there is no way out, go back to last cell
			else {
				if (stack.head != null) {
					stack.pop();
					i = stack.top().getRow();
					j = stack.top().getCol();
				}
			}
		}
		stack.display();
	}

	public static void main(String[] args) throws FileNotFoundException {

		// create the Maze from the file
		Scanner fin = new Scanner(new File("Maze.in"));
		// read in the rows and cols
		int rows = fin.nextInt();
		int cols = fin.nextInt();

		// create the maze
		int[][] grid = new int[rows][cols];

		// read in the data from the file to populate
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				grid[i][j] = fin.nextInt();
			}
		}

		// look at it
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 3)
					System.out.print("S ");
				else if (grid[i][j] == 4)
					System.out.print("E ");
				else
					System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}

		// make a 2-d array of cells
		MazeCell[][] cells = new MazeCell[rows][cols];

		// populate with MazeCell obj - default obj for walls

		MazeCell start = new MazeCell(), end = new MazeCell();

		// iterate over the grid, make cells and set coordinates
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				// make a new cell
				cells[i][j] = new MazeCell();
				// if it isn't a wall, set the coordinates
				if (grid[i][j] != 0) {
					cells[i][j].setCoordinates(i, j);
					// look for the start and end cells
					if (grid[i][j] == 3)
						start = cells[i][j];
					if (grid[i][j] == 4)
						end = cells[i][j];

				}

			}
		}

		// testing
		System.out.println("start:" + start + " end:" + end);

		// solve it!
		depthFirst(cells, start, end);

	}
}

/*
 *
 * Provided starter code MazeCell class DO NOT CHANGE THIS CLASS
 *
 * models an open cell in a maze each cell knows its coordinates (row, col),
 * direction keeps track of the next unchecked neighbor\ cell is considered
 * 'visited' once processing moves to a neighboring cell the visited variable is
 * necessary so that a cell is not eligible for visits from the cell just
 * visited
 *
 */

class MazeCell {
	private int row, col;
	// direction to check next
	// 0: north, 1: east, 2: south, 3: west, 4: complete
	private int direction;
	private boolean visited;

	// set row and col with r and c
	public MazeCell(int r, int c) {
		row = r;
		col = c;
		direction = 0;
		visited = false;
	}

	// no-arg constructor
	public MazeCell() {
		row = col = -1;
		direction = 0;
		visited = false;
	}

	// copy constructor
	MazeCell(MazeCell rhs) {
		this.row = rhs.row;
		this.col = rhs.col;
		this.direction = rhs.direction;
		this.visited = rhs.visited;
	}

	public int getDirection() {
		return direction;
	}

	// update direction. if direction is 4, mark cell as visited
	public void advanceDirection() {
		direction++;
		if (direction == 4)
			visited = true;
	}

	// change row and col to r and c
	public void setCoordinates(int r, int c) {
		row = r;
		col = c;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MazeCell other = (MazeCell) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

	// set visited status to true
	public void visit() {
		visited = true;
	}

	// reset visited status
	public void reset() {
		visited = false;
	}

	// return true if this cell is unvisited
	public boolean unVisited() {
		return !visited;
	}

	// may be useful for testing, return string representation of cell
	public String toString() {
		return "(" + row + "," + col + ")";
	}
} // end of MazeCell class
