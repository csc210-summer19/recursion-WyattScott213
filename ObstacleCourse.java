/**
 * ObstacleCourse: A type that represents an obstacle course from which to
 * escape. This does not find the shorted path. Because of this, we must always
 * assume there is only one exit.
 */
// Author: Rick Mercer and Wyatt Scott

public class ObstacleCourse {

	// Instance variables
	protected char[][] course;
	private int sRow;
	private int sCol;
	private int foundRow;
	private int foundCol;

	// Constants (or you could use 'O' and '.' directly)
	private static final char PART_OF_PATH = 'O';
	private static final char TRIED = '.';

	/**
	 * Initializes the 2d char array course.
	 */
	public ObstacleCourse(int sRow, int sCol, char[][] course) {
		this.sRow = sRow;
		this.sCol = sCol;
		this.course = course;

		// The default values in case there is no exit.
		foundRow = -1;
		foundCol = -1;
	}

	// Returns the start column in the array
	public int getStartColumn() {
		return sCol;
	}

	// Returns the starting row in the array
	public int getStartRow() {
		return sRow;
	}

	// Return the column of the solution
	public int getExitColumn() {
		return foundCol;
	}

	// Return the row of the solution
	public int getExitRow() {
		return foundRow;
	}

	// Returns a string representation of the array
	public String toString() {
		String result = "";
		for (int i = 0; i < course.length; i++) {
			for (int j = 0; j < course[0].length; j++) {
				result += course[i][j];
			}
			result += "\n";
		}
		return result;
	}

	// This method is called by the user to begin the search for the one exit.
	public void findTheExit() {
		findExit(0, 0);
	}

	/**
	 * Finds the exit from the 2-D array. This method also must record the row and
	 * col where the exit was found
	 */
	private boolean findExit(int row, int col) {
		// TODO: Complete this method
		//
		// Do not forget to set the instance variable foundRow and
		// foundCol in this method when the exit is found.
		//
		int GRows = course.length;
		int GCols = course[0].length;
		if (row == 0 && col != GCols) {
			if (course[row][col] == ' ') {
				foundRow = 0;
				foundCol = col;
			} else if (course[row][col] != ' ')
				findExit(row, col + 1);
			if (col == GCols - 1)
				findExit(row + 1, 0);
		} else if (row != 0 && row != GRows - 1 && col != GCols) {
			if (course[row][col] == ' ') {
				foundRow = row;
				foundCol = col;
				return true;
			} else if (col == 0 && course[row][col] != ' ')
				findExit(row, GCols - 1);
			else if (col == GCols - 1 && course[row][col] != ' ')
				findExit(row + 1, 0);
		} else if (row == GRows - 1 && col != GCols) {
			if (course[row][col] == ' ') {
				foundRow = row;
				foundCol = col;
				return true;
			} else
				findExit(row, col + 1);
		}

		return false;
	}

}