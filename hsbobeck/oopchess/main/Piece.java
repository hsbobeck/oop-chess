/**
 * 
 * @author Henry Bobeck
 * @version 1.0 2020-06-28
 * 
 */
package hsbobeck.oopchess.main;

public abstract class Piece {
	private boolean white; // (the team: 0-black, 1-white)
	private int moveCount; // keeps track of how many times this piece has been moved

	/**
	 * @param white (the team: 0-black, 1-white)
	 */
	public Piece(boolean white) {
		this.white = white;
	}
	
	/**
	 * 
	 * @author Henry Bobeck
	 *
	 */
	public class PieceNotFoundException extends Exception {
		public PieceNotFoundException(String errorMessage) {
	        super(errorMessage);
	    }
		public PieceNotFoundException() {
	        super();
	    }
		
	}
	
	/**
	 * given the current board, which should include this piece, return a grid of possible move options
	 * @param board the current state of the board
	 * @return an 8x8 matrix with values of 'true' where a move is available
	 */
	public abstract boolean[][] getMoveOptions(Piece[][] board) throws PieceNotFoundException;

	/**
	 * @return if this is a White piece
	 */
	public boolean isWhite() {
		return white;
	}

	/**
	 * @return the moveCount
	 */
	public int getMoveCount() {
		return moveCount;
	}

	/**
	 * @param moveCount the moveCount to set
	 */
	public void setMoveCount(int moveCount) {
		this.moveCount = moveCount;
	}
	
	public void reportMove() {
		this.moveCount++;
	}
	
	/**
	 * @return string representing the piece type
	 */
	public abstract String getPieceType();
	
	@Override
	public abstract String toString();
	
}
