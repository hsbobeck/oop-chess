/**
 * 
 * @author Henry Bobeck
 * @version 1.0 2020-06-28
 * 
 */
package hsbobeck.oopchess.main;

public class Knight extends Piece {
	
	/**
	 * @param white (the team: 0-black, 1-white)
	 */
	public Knight(boolean white) {
		super(white);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean[][] getMoveOptions(Piece[][] board) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {
		if(this.isWhite())
		{
			return "wK";
		}
		else
		{
			return "bK";
		}
	}

	@Override
	public String getPieceType() {
		return "knight";
	}

}
