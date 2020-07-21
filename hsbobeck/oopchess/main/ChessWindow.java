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
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChessWindow extends JFrame {

	private ChessDriver driver;
	private Coordinate currentSelection;
	private Coordinate prevSelection;
	private JPanel[][] tiles; // 2d reference array which holds all tiles
	private Color tileColor1 = new Color(121, 72, 56);
	private Color tileColor2 = new Color(92, 50, 48);
	private Color tileColorSelection = new Color(213, 132, 131);
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
        bgPanel.setPreferredSize(new Dimension(720, 720));
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
        
        refreshTileColors();
        
        bgPanel.add(grid);
        setContentPane(bgPanel);
        pack();
	}
	
	/**
	 * draws all pieces to their correct spots on the board
	 */
	private void drawPieces() {
		
	}
	
	/**
	 * returns all tile colors to normal
	 */
	private void refreshTileColors() {
		for(int row=0; row<8; row++)
        {
        	for(int col=0; col<8; col++)
        	{
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
	
	
	
	private class TileListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent event) {
                    /* source is the object that got clicked
                     * 
                     * If the source is actually a JPanel, 
                     * then will the object be parsed to JPanel 
                     * since we need the setBackground() method
                     */
            Object source = event.getSource();
            if(source instanceof JPanel){
            	
            	refreshTileColors();
            	prevSelection = currentSelection;
            	currentSelection = Coordinate.getCoordinate(tiles, (JPanel)source);
//            	System.out.println("current selection: " + currentSelection);
            	driver.updateBoard(prevSelection, currentSelection);
                ((JPanel) source).setBackground(tileColorSelection);
                
            }
        }

        @Override
        public void mouseEntered(MouseEvent arg0) {}

        @Override
        public void mouseExited(MouseEvent arg0) {}

        @Override
        public void mousePressed(MouseEvent arg0) {}

        @Override
        public void mouseReleased(MouseEvent arg0) {}

    }
	
	

}
