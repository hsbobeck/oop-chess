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
	public boolean[][] getMoveOptions(Piece[][] board) throws PieceNotFoundException {
		boolean[][] result = new boolean[8][8];
		
		Coordinate pieceLocation = Coordinate.getCoordinate(board, (Piece)this); 
		if(pieceLocation == null) throw new PieceNotFoundException();
		int row = pieceLocation.getRow();
		int col = pieceLocation.getCol();
		
		Coordinate[] attackOptions;
		Coordinate[] moveOptions;
		
		int teamMod = this.isWhite() ? -1 : 1;
		
		
		attackOptions = new Coordinate[]{new Coordinate(row+1*teamMod, col-1), new Coordinate(row+1*teamMod, col+1)};
		if(this.getMoveCount()==0)
		{
			moveOptions = new Coordinate[]{new Coordinate(row+1*teamMod, col), new Coordinate(row+2*teamMod, col)};
		}
		else
		{
			moveOptions = new Coordinate[]{new Coordinate(row+1*teamMod, col)};
		}
		
		for(Coordinate c : attackOptions)
		{
			if(c.isOOB()) continue;
			Piece target = Coordinate.objAtCoordinate(board, c);
			if(target!=null && target.isWhite()!=this.isWhite())
			{
				result[c.getRow()][c.getCol()] = true;
			}
		}
		
		for(Coordinate c : moveOptions)
		{
			if(c.isOOB()) continue;
			Piece target = Coordinate.objAtCoordinate(board, c);
			if(target==null)
			{
				result[c.getRow()][c.getCol()] = true;
			}
		}
		
		
		
//		for(int row=0; row<8; row++)
//		{
//			for(int col=0; col<8; col++)
//			{
//				result[row][col] = true;
//			}
//		}
		
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
