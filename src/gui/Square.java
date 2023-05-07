package gui;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author zmaster
 */
public class Square extends JPanel implements MouseListener {
    int x;
    int y;
    public Square(int x, int y)
    {
        this.x = x;
        this.y = y;
        
        addMouseListener(this);  
    }
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        System.out.println(" " + x + " " + y); 
        
    }
    
    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }
}

