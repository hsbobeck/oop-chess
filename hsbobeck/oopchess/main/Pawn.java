/**
 * 
 * @author Henry Bobeck
 * @version 1.0 2020-06-28
 * 
 */
package hsbobeck.oopchess.main;

public class Pawn extends Piece {
	
	/**
	 * @param white (the team: 0-black, 1-white)
	 */
	public Pawn(boolean white) {
		super(white);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean[][] getMoveOptions(Piece[][] board) {
		boolean[][] result = new boolean[8][8];
		
		for(int row=0; row<8; row++)
		{
			for(int col=0; col<8; col++)
			{
				result[row][col] = true;
			}
		}
		
		return result;
	}
	
	public String toString() {
		if(this.isWhite())
		{
			return "wP";
		}
		else
		{
			return "bP";
		}
	}

}
