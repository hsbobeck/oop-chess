/**
 * 
 * @author Henry Bobeck
 * @version 1.0 2020-07-18
 * 
 */
package hsbobeck.oopchess.main;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChessWindow extends JFrame {

	/**
	 * 
	 */
	public ChessWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("OOP Chess!");
        setVisible(true);

        JPanel bgPanel = new JPanel();
        
        ImageIcon boardImage = new ImageIcon("img\\chessboard.jpg");
        JLabel boardLabel = new JLabel(boardImage);
        
        bgPanel.add(boardLabel);
        
        setContentPane(bgPanel);
        
        // set up 8x8 grid layout of panels
        JPanel content = new JPanel(new GridLayout(8, 8));
        JPanel[] panels = new JPanel[64];
        PanelListener listener = new PanelListener();
        
        for(int i=0; i<64; i++)
        {
        	panels[i] = new JPanel();
            panels[i].setBackground(Color.white);
            panels[i].addMouseListener(listener);
            content.add(panels[i]);
        }
        
        bgPanel.add(content);
        
        pack();
	}
	
	private class PanelListener implements MouseListener {

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
                JPanel panelPressed = (JPanel) source;
                panelPressed.setBackground(Color.blue);
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
