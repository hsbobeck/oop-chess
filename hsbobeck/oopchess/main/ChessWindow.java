/**
 * 
 * @author Henry Bobeck
 * @version 1.0 2020-07-18
 * 
 */
package hsbobeck.oopchess.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import hsbobeck.oopchess.exceptions.PieceNotFoundException;

public class ChessWindow extends JFrame {

	private ChessDriver driver;
	private Coordinate currentSelection;
	private Coordinate prevSelection;
	private JPanel[][] tiles; // 2d reference array which holds all tiles
	private Color tileColor1 = new Color(121, 72, 56);
	private Color tileColor2 = new Color(92, 50, 48);
	private Color tileColorSelection = new Color(213, 132, 131);
	private Color moveIndicatorColor = new Color(224, 206, 153);
	private Border moveIndicatorBorder = BorderFactory.createLineBorder(moveIndicatorColor, 3);
	private final Dimension BOARD_DIMENSION = new Dimension(720, 720);
	private TileListener listener;
	
	
	
	/**
	 * constructs the window & content
	 */
	public ChessWindow(ChessDriver driver) {
		this.driver = driver;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("OOP Chess!");
        setVisible(true);
        
        JPanel bgPanel = new JPanel();
        bgPanel.setPreferredSize(BOARD_DIMENSION);
        bgPanel.setLayout(new BorderLayout());   
        
        // set up 8x8 grid layout of tiles
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(8, 8));
        // construct 2d reference array
        tiles = new JPanel[8][8];
        // construct the TileListener to be used
        listener = new TileListener();
        
        // fill the grid with tiles with mouse listeners attached
        for(int row=0; row<8; row++)
        {
        	for(int col=0; col<8; col++)
        	{
        		// construct each individual tile and add it to a reference array
        		tiles[row][col] = new JPanel();
        		
        		// apply the TileListener to the tile
        		tiles[row][col].addMouseListener(listener);
        		
        		// add the tile to the grid
                grid.add(tiles[row][col]);
        	}
        }
        
        
        
        
        
        bgPanel.add(grid);
        setContentPane(bgPanel);
        pack();
        refreshTileColors();
        drawPieces();
        validate();
	}
	
	/**
	 * draws all pieces to their correct spots on the board
	 */
	private void drawPieces() {
		for(int row=0; row<8; row++)
		{
			for(int col=0; col<8; col++)
			{
				drawPieces(new Coordinate(row, col));
			}
		}
	}
	
	/**
	 * redraws piece icon only at the single given coordinate
	 * @param coord
	 */
	private void drawPieces(Coordinate coord) {
		Piece[][] board = this.driver.getBoard();
		int row = coord.getRow();
		int col = coord.getCol();
		
		tiles[row][col].removeAll();
		Piece currentPiece = board[row][col];
		if(currentPiece != null)
		{
			String color = currentPiece.getColor();
			String type = currentPiece.getPieceType();
			try {
				final BufferedImage img = ImageIO.read(new File("src\\hsbobeck\\oopchess\\img\\JohnPablok Cburnett Chess set\\PNGs\\With Shadow\\1x\\" + color.substring(0, 1) + "_" + type + "_1x.png"));
				
				Image scaledImg = img.getScaledInstance(tiles[row][col].getWidth(), tiles[row][col].getHeight(), Image.SCALE_SMOOTH);
				tiles[row][col].add(new JLabel(new ImageIcon(scaledImg)));
			} catch (IOException e) {
				System.out.println("image file not properly found");
			}
			
		}
	}
	
	/**
	 * redraws piece icons only at the given coordinates
	 * @param prev
	 * @param curr
	 */
	private void drawPieces(Coordinate prev, Coordinate curr) {
		drawPieces(prev);
		drawPieces(curr);
	}
	
	/**
	 * returns all tile colors to normal
	 */
	private void refreshTileColors() {
		for(int row=0; row<8; row++)
        {
        	for(int col=0; col<8; col++)
        	{
        		tiles[row][col].setBorder(null);
        		if(row%2==0)
        		{
        			if(col%2==0)
                	{
        				tiles[row][col].setBackground(tileColor1);
                	}
                	else
                	{
                		tiles[row][col].setBackground(tileColor2);
                	}
        		}
        		else
        		{
        			if(col%2==0)
                	{
        				tiles[row][col].setBackground(tileColor2);
                	}
                	else
                	{
                		tiles[row][col].setBackground(tileColor1);
                	}
        		}
        	}
        }
	}
	
	private void drawMoveOptionIndicators() {
		if(currentSelection==null) return;
		Piece currentPiece = driver.getBoard()[currentSelection.getRow()][currentSelection.getCol()];
		boolean[][] moveOptions;
		if(currentPiece != null && currentPiece.isWhite() == driver.whiteTurn)
		{
			try {
				
				moveOptions = currentPiece.getMoveOptions(driver.getBoard());
				for(int row=0; row<8; row++)
				{
					for(int col=0; col<8; col++)
					{
						if(moveOptions[row][col])
						{
							tiles[row][col].setBorder(moveIndicatorBorder);
						}
					}
				}
				
			} catch (PieceNotFoundException e) {
				e.printStackTrace();
				System.out.println("unable to draw move option indicators");
			}
			
		}
	}
	
	
	
	private class TileListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent event) {}

        @Override
        public void mouseEntered(MouseEvent event) {}

        @Override
        public void mouseExited(MouseEvent event) {}

        @Override
        public void mousePressed(MouseEvent event) {
		    Object source = event.getSource();
		    if(source instanceof JPanel){
		    	
		    	refreshTileColors();
		    	
		    	prevSelection = currentSelection;
		    	currentSelection = Coordinate.getCoordinate(tiles, (JPanel)source);
		    	
		    	((JPanel) source).setBackground(tileColorSelection);
		    	
		    	// only redraw the pieces where the board actually changes
		    	if(driver.updateBoard(prevSelection, currentSelection)) {
		    		drawPieces(prevSelection, currentSelection);
		    		currentSelection=null;
		    		prevSelection=null;
		    		refreshTileColors();
		    	}
		    	
		        drawMoveOptionIndicators();
		    	
		    	validate();
		        
		        
		    }
        }

        @Override
        public void mouseReleased(MouseEvent arg0) {}

    }
	
	

}
