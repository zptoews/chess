package gui;

import javax.swing.JPanel;
import java.awt.event.*;
import game.Piece;

/**
 *
 * @author zmaster
 */
public class Square extends JPanel implements MouseListener {

    int x;
    int y;
    Piece pieceInSquare = null;

    public Square(int x, int y, Piece pieceInSquare) {
        this.x = x;
        this.y = y;
        
        this.pieceInSquare = pieceInSquare;
        
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
