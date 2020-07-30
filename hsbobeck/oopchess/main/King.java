/**
 * 
 * @author Henry Bobeck
 * @version 1.0 2020-06-28
 * 
 */
package hsbobeck.oopchess.main;

import hsbobeck.oopchess.exceptions.PieceNotFoundException;

public class King extends Piece {
	
	private static final String pieceType = "king";
	
	/**
	 * @param white (the team: 0-black, 1-white)
	 */
	public King(boolean white) {
		super(white);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean[][] getMoveOptions(Piece[][] board) throws PieceNotFoundException {
		//SETUP
		boolean[][] moveOptions = new boolean[8][8];
		
		Coordinate pieceLocation = Coordinate.getCoordinate(board, (Piece)this); 
		if(pieceLocation == null) throw new PieceNotFoundException();
		int row = pieceLocation.getRow();
		int col = pieceLocation.getCol();
		
		Coordinate[] moveSet;
		
		//LOGIC
		// a king's moveset
		moveSet = new Coordinate[] {
			new Coordinate(row+1, col+1), 
			new Coordinate(row+1, col-1),
			new Coordinate(row-1, col+1),
			new Coordinate(row-1, col-1),
			new Coordinate(row+1, col),
			new Coordinate(row-1, col),
			new Coordinate(row, col+1),
			new Coordinate(row, col-1),
		};
		
		// decides which in the moveset is valid
		for(Coordinate c : moveSet)
		{
			if(c.isOOB()) continue;
			Piece target = Coordinate.objAtCoordinate(board, c);
			if(target==null || board[c.getRow()][c.getCol()].isWhite() != this.isWhite())
			{
				moveOptions[c.getRow()][c.getCol()] = true;
			}
		}
		
		
		return moveOptions;
	}

	public String toString() {
		if(this.isWhite())
		{
			return "w*";
		}
		else
		{
			return "b*";
		}
	}

	@Override
	public String getPieceType() {
		return pieceType;
	}
}
