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

	private JPanel currentSelectedTile;
	private JPanel[] tiles;
	private Color tileColor1 = new Color(121, 72, 56);
	private Color tileColor2 = new Color(92, 50, 48);
	private Color tileColorSelection = new Color(213, 132, 131);
	
	
	
	/**
	 * 
	 */
	public ChessWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("OOP Chess!");
        setVisible(true);
        

        JPanel bgPanel = new JPanel();
        bgPanel.setPreferredSize(new Dimension(720, 720));
        bgPanel.setLayout(new BorderLayout());   
        
        
        
        // set up 8x8 grid layout of panels
        JPanel grid = new JPanel();
        grid.setSize(1080, 1080);
        grid.setLayout(new GridLayout(8, 8));
        tiles = new JPanel[64];
        TileListener listener = new TileListener();
        
        // fill the grid with appropriately colored panels with mouse listeners attached
        for(int row=0; row<8; row++)
        {
        	for(int col=0; col<8; col++)
        	{
        		tiles[8*row+col] = new JPanel();
        		if(row%2==0)
        		{
        			if(col%2==0)
                	{
                		tiles[8*row+col].setBackground(tileColor1);
                	}
                	else
                	{
                		tiles[8*row+col].setBackground(tileColor2);
                	}
        		}
        		else
        		{
        			if(col%2==0)
                	{
        				tiles[8*row+col].setBackground(tileColor2);
                	}
                	else
                	{
                		tiles[8*row+col].setBackground(tileColor1);
                	}
        		}
        		
        		tiles[8*row+col].addMouseListener(listener);
                grid.add(tiles[8*row+col]);
        	}
        }
        
        bgPanel.add(grid);
        
        setContentPane(bgPanel);
        pack();
	}
	
	private void refreshTileColors() {
		for(int row=0; row<8; row++)
        {
        	for(int col=0; col<8; col++)
        	{
        		if(row%2==0)
        		{
        			if(col%2==0)
                	{
                		tiles[8*row+col].setBackground(tileColor1);
                	}
                	else
                	{
                		tiles[8*row+col].setBackground(tileColor2);
                	}
        		}
        		else
        		{
        			if(col%2==0)
                	{
        				tiles[8*row+col].setBackground(tileColor2);
                	}
                	else
                	{
                		tiles[8*row+col].setBackground(tileColor1);
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
            	currentSelectedTile = (JPanel) source;
                currentSelectedTile.setBackground(tileColorSelection);
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
