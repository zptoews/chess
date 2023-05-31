package gui;

import javax.swing.JPanel;
import java.awt.event.*;
import game.Piece;
import game.ChessBoard;
import java.awt.Graphics;
import javax.swing.*;

/**
 *
 * @author zmaster
 */
public class Square extends JPanel implements MouseListener {

    int file;//global to class file variable
    int rank;//global to class rank variable
    Piece pieceInSquare = null;
    ChessBoard chessBoard = new ChessBoard();
    
    final String WPawn = "resources/game/WPrawn.png";//imports for the images
    ImageIcon WPimage = new ImageIcon(WPawn);//imports for the images

    final String WQueen = "resources/game/WQueen.png";//imports for the images
    ImageIcon WQimage = new ImageIcon(WQueen);//imports for the images
    
    final String WKing = "resources/game/WKing.png";//imports for the images
    ImageIcon WKimage = new ImageIcon(WKing);//imports for the images
    
    final String WBishop = "resources/game/WBishop.png";//imports for the images
    ImageIcon WBimage = new ImageIcon(WBishop);//imports for the images
    
    final String WHorse = "resources/game/WHorse.png";//imports for the images
    ImageIcon WHimage = new ImageIcon(WHorse);//imports for the images
    
    final String WRook = "resources/game/WRook.png";//imports for the images
    ImageIcon WRimage = new ImageIcon(WRook);//imports for the images
    
    public Square(int file, int rank, Piece pieceInSquare) {
        this.file = file;
        this.rank = rank;

        this.pieceInSquare = pieceInSquare;

        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        System.out.println(" " + file + " " + rank);//to tell the rank and file of the square clicked
        //chessBoard.getPiece(file, rank);
        if (chessBoard.getPiece(file, rank) != null) {
            System.out.println("There is piece here");
        }

    }

    public void paint(Graphics g) {
        super.paint(g);
        if (chessBoard.getPiece(file, rank) != null) {
            //To print out the correct images for the pieces            
            if (chessBoard.getPiece(file, rank).pieceName.equals("Pawn")) {
                WPimage.paintIcon(this, g, file, rank);
            }
            //To print out the correct images for the pieces  
            if (chessBoard.getPiece(file, rank).pieceName.equals("King")) {
                WKimage.paintIcon(this, g, file, rank);
            }
            //To print out the correct images for the pieces  
            if (chessBoard.getPiece(file, rank).pieceName.equals("Queen")) {
                WQimage.paintIcon(this, g, file, rank);
            }
            //To print out the correct images for the pieces  
            if (chessBoard.getPiece(file, rank).pieceName.equals("Bishop")) {
                WBimage.paintIcon(this, g, file, rank);
            }
            //To print out the correct images for the pieces  
            if (chessBoard.getPiece(file, rank).pieceName.equals("Horse")) {
                WHimage.paintIcon(this, g, file, rank);
            }
            //To print out the correct images for the pieces  
            if (chessBoard.getPiece(file, rank).pieceName.equals("Rook")) {
                WRimage.paintIcon(this, g, file, rank);
            }
        }
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
