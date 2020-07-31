/**
 * 
 * @author Henry Bobeck
 * @version 1.0 2020-06-28
 * 
 */
package hsbobeck.oopchess.main;

import hsbobeck.oopchess.exceptions.PieceNotFoundException;

public class Pawn extends Piece {
	
	private static final String pieceType = "pawn";
	
	/**
	 * @param white (the team: 0-black, 1-white)
	 */
	public Pawn(boolean white) {
		super(white);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean[][] getMoveOptions(Piece[][] board) throws PieceNotFoundException {
		boolean[][] moveOptions = new boolean[8][8];
		
		Coordinate pieceLocation = Coordinate.getCoordinate(board, (Piece)this); 
		if(pieceLocation == null) throw new PieceNotFoundException();
		int row = pieceLocation.getRow();
		int col = pieceLocation.getCol();
		
		Coordinate[] attackSet;
		Coordinate[] moveSet;
		
		int teamMod = this.isWhite() ? -1 : 1;
		
		
		attackSet = new Coordinate[]{new Coordinate(row+1*teamMod, col-1), new Coordinate(row+1*teamMod, col+1)};
		if(this.getMoveCount()==0)
		{
			moveSet = new Coordinate[]{new Coordinate(row+1*teamMod, col), new Coordinate(row+2*teamMod, col)};
		}
		else
		{
			moveSet = new Coordinate[]{new Coordinate(row+1*teamMod, col)};
		}
		
		for(Coordinate c : attackSet)
		{
			if(c.isOOB()) continue;
			Piece target = Coordinate.objAtCoordinate(board, c);
			if(target!=null && target.isWhite()!=this.isWhite())
			{
				moveOptions[c.getRow()][c.getCol()] = true;
			}
		}
		
		
		for(Coordinate c : moveSet)
		{
			if(moveSet.length >1)
			{
				if(Coordinate.objAtCoordinate(board, moveSet[0])!=null) break;
			}
			if(c.isOOB()) continue;
			Piece target = Coordinate.objAtCoordinate(board, c);
			if(target==null)
			{
				moveOptions[c.getRow()][c.getCol()] = true;
			}
		}
		
		return moveOptions;
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

	@Override
	public String getPieceType() {
		return pieceType;
	}

}
