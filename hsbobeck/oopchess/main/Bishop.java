/**
 * 
 * @author Henry Bobeck
 * @version 1.0 2020-06-28
 * 
 */
package hsbobeck.oopchess.main;

import hsbobeck.oopchess.exceptions.PieceNotFoundException;

public class Bishop extends Piece {
	
	private static final String pieceType = "bishop";
	
	/**
	 * @param white (the team: 0-black, 1-white)
	 */
	public Bishop(boolean white) {
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
		
		int checkingRow;
		int checkingCol;
		
		//LOGIC
		
		
		// look up&left
		checkingRow = row-1;
		checkingCol = col-1;
		while(checkingRow>=0 && checkingCol>=0) {
			if(board[checkingRow][checkingCol]==null)
			{
				moveOptions[checkingRow][checkingCol] = true;
			}
			else if(board[checkingRow][checkingCol].isWhite() != this.isWhite())
			{
				moveOptions[checkingRow][checkingCol] = true;
				break;
			}
			else
			{
				break;
			}
			checkingRow--;
			checkingCol--;
		}
		// look up&right
		checkingRow = row+1;
		checkingCol = col-1;
		while(checkingRow<8 && checkingCol>=0) {
			if(board[checkingRow][checkingCol]==null)
			{
				moveOptions[checkingRow][checkingCol] = true;
			}
			else if(board[checkingRow][checkingCol].isWhite() != this.isWhite())
			{
				moveOptions[checkingRow][checkingCol] = true;
				break;
			}
			else
			{
				break;
			}
			checkingRow++;
			checkingCol--;
		}
		// look down&left
		checkingRow = row-1;
		checkingCol = col+1;
		while(checkingRow>=0 && checkingCol<8) {
			if(board[checkingRow][checkingCol]==null)
			{
				moveOptions[checkingRow][checkingCol] = true;
			}
			else if(board[checkingRow][checkingCol].isWhite() != this.isWhite())
			{
				moveOptions[checkingRow][checkingCol] = true;
				break;
			}
			else
			{
				break;
			}
			checkingRow--;
			checkingCol++;
		}
		// look down&right
		checkingRow = row+1;
		checkingCol = col+1;
		while(checkingRow<8 && checkingCol<8) {
			if(board[checkingRow][checkingCol]==null)
			{
				moveOptions[checkingRow][checkingCol] = true;
			}
			else if(board[checkingRow][checkingCol].isWhite() != this.isWhite())
			{
				moveOptions[checkingRow][checkingCol] = true;
				break;
			}
			else
			{
				break;
			}
			checkingRow++;
			checkingCol++;
		}
		
		
		
		return moveOptions;
	}
	
	public String toString() {
		if(this.isWhite())
		{
			return "wB";
		}
		else
		{
			return "bB";
		}
	}

	@Override
	public String getPieceType() {
		return pieceType;
	}

}
