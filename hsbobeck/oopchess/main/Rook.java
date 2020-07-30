/**
 * 
 * @author Henry Bobeck
 * @version 1.0 2020-06-28
 * 
 */
package hsbobeck.oopchess.main;

import hsbobeck.oopchess.exceptions.PieceNotFoundException;

public class Rook extends Piece {
	
	private static final String pieceType = "rook";
	
	/**
	 * @param white (the team: 0-black, 1-white)
	 */
	public Rook(boolean white) {
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
		
		//LOGIC
		
		// look down
		for(int c=col+1; c<8; c++)
		{
			if(board[row][c]==null)
			{
				moveOptions[row][c] = true;
			}
			else if(board[row][c].isWhite() != this.isWhite())
			{
				moveOptions[row][c] = true;
				break;
			}
			else
			{
				break;
			}
		}
		// look up
		for(int c=col-1; c>-1; c--)
		{
			if(board[row][c]==null)
			{
				moveOptions[row][c] = true;
			}
			else if(board[row][c].isWhite() != this.isWhite())
			{
				moveOptions[row][c] = true;
				break;
			}
			else
			{
				break;
			}
		}
		// look left
		for(int r=row-1; r>-1; r--)
		{
			if(board[r][col]==null)
			{
				moveOptions[r][col] = true;
			}
			else if(board[r][col].isWhite() != this.isWhite())
			{
				moveOptions[r][col] = true;
				break;
			}
			else
			{
				break;
			}
		}
		// look right
		for(int r=row+1; r<8; r++)
		{
			if(board[r][col]==null)
			{
				moveOptions[r][col] = true;
			}
			else if(board[r][col].isWhite() != this.isWhite())
			{
				moveOptions[r][col] = true;
				break;
			}
			else
			{
				break;
			}
		}
		
		return moveOptions;
	}
	
	public String toString() {
		if(this.isWhite())
		{
			return "wR";
		}
		else
		{
			return "bR";
		}
	}

	@Override
	public String getPieceType() {
		return pieceType;
	}

}
