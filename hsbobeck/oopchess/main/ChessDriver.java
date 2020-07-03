/**
 * 
 * @author Henry Bobeck
 * @version 1.0 2020-06-28
 * 
 */
package hsbobeck.oopchess.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChessDriver implements ActionListener {

	public Piece[][] board;
	boolean whiteTurn; // (whose turn it is; 0-black, 1-white)
	Coordinate currentSelection;
	ArrayList<Piece> graveyardWhite;
	ArrayList<Piece> graveyardBlack;
	
	public ChessDriver()
	{
		this.board = new Piece[8][8];
		// populate board:
		board[0][0] = new Rook(false);
		board[0][1] = new Knight(false);
		board[0][2] = new Bishop(false);
		board[0][3] = new Queen(false);
		board[0][4] = new King(false);
		board[0][5] = new Bishop(false);
		board[0][6] = new Knight(false);
		board[0][7] = new Rook(false);
		
		board[1][0] = new Pawn(false);
		board[1][1] = new Pawn(false);
		board[1][2] = new Pawn(false);
		board[1][3] = new Pawn(false);
		board[1][4] = new Pawn(false);
		board[1][5] = new Pawn(false);
		board[1][6] = new Pawn(false);
		board[1][7] = new Pawn(false);
		
		board[6][0] = new Pawn(true);
		board[6][1] = new Pawn(true);
		board[6][2] = new Pawn(true);
		board[6][3] = new Pawn(true);
		board[6][4] = new Pawn(true);
		board[6][5] = new Pawn(true);
		board[6][6] = new Pawn(true);
		board[6][7] = new Pawn(true);
		
		board[7][0] = new Rook(true);
		board[7][1] = new Knight(true);
		board[7][2] = new Bishop(true);
		board[7][3] = new Queen(true);
		board[7][4] = new King(true);
		board[7][5] = new Bishop(true);
		board[7][6] = new Knight(true);
		board[7][7] = new Rook(true);
		
		
		
		this.whiteTurn = true;
		this.currentSelection = null;
		this.graveyardWhite = new ArrayList<Piece>();
		this.graveyardBlack = new ArrayList<Piece>();
	}
	
	@Override
	public void actionPerformed(ActionEvent click)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString()
	{
		String result = "";
		
		for(int row=0; row<board.length; row++)
		{
			for(int col=0; col<board[0].length; col++)
			{
				
				if(board[row][col] == null)
				{
					result+= "--";
				}
				else
				{
					result+=board[row][col].toString();
				}
				
				
				if(col < board.length-1)
				{
					result+= "  ";
				}
				else
				{
					result+= "\n";
				}
				
			}
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		ChessDriver foobar = new ChessDriver();
		System.out.println(foobar);
	}
	
}
