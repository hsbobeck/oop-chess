/**
 * 
 * @author Henry Bobeck
 * @version 1.0 2020-06-28
 * 
 */
package hsbobeck.oopchess.main;

public class Coordinate {
	private int row;
	private int col;
	
	/**
	 * @param row
	 * @param col
	 */
	public Coordinate(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	/**
	 * returns a coordinate of the given object in the given grid, null if not found
	 * @param <T>
	 * @param arr
	 * @param target
	 * @return the Coordinate of the target object
	 */
	public static <T> Coordinate getCoordinate(T[][] arr, T target) {
		Coordinate result;
		for(int row=0; row<arr.length; row++)
		{
			for(int col=0; col<arr[0].length; col++)
			{
				if(arr[row][col] == target)
				{
					result = new Coordinate(row, col);
					return result;
				}
			}
		}
		return null;
	}
	
	/**
	 * returns the object at the given coordinate in the given grid
	 * @param <T>
	 * @param arr
	 * @param c
	 * @return the target object
	 */
	public static <T> T objAtCoordinate(T[][] arr, Coordinate c) {
		return arr[c.getRow()][c.getCol()];
	}
	
	/**
	 * @return if this coordinate is off the 8x8 grid
	 */
	public boolean isOOB() {
		return !(row>=0 && row<=7 && col>=0 && col<=7);
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @return the column
	 */
	public int getCol() {
		return col;
	}

	@Override
	public String toString() {
		return "[" + row + ", " + col + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Coordinate)
		{
			return this.row==((Coordinate)o).getRow() && this.col==((Coordinate)o).getCol();
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
}
