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

    int file;
    int rank;
    Piece pieceInSquare = null;
    ChessBoard chessBoard = new ChessBoard();

    final String WPawn = "resources/game/WPrawn.png";
    ImageIcon WPimage = new ImageIcon(WPawn);

    final String WQueen = "resources/game/WQueen.png";
    ImageIcon WQimage = new ImageIcon(WQueen);
    
    final String WKing = "resources/game/WKing.png";
    ImageIcon WKimage = new ImageIcon(WKing);
    
    final String WBishop = "resources/game/WBishop.png";
    ImageIcon WBimage = new ImageIcon(WBishop);
    
    final String WHorse = "resources/game/WHorse.png";
    ImageIcon WHimage = new ImageIcon(WHorse);
    
    final String WRook = "resources/game/WRook.png";
    ImageIcon WRimage = new ImageIcon(WRook);
    
    public Square(int file, int rank, Piece pieceInSquare) {
        this.file = file;
        this.rank = rank;

        this.pieceInSquare = pieceInSquare;

        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        System.out.println(" " + file + " " + rank);
        //chessBoard.getPiece(file, rank);
        if (chessBoard.getPiece(file, rank) != null) {
            System.out.println("There is piece here");
        }

    }

    public void paint(Graphics g) {
        super.paint(g);
        if (chessBoard.getPiece(file, rank) != null) {
            //System.out.println("There is piece here");            
            if (chessBoard.getPiece(file, rank).pieceName.equals("Pawn")) {
                WPimage.paintIcon(this, g, file, rank);
            }
            if (chessBoard.getPiece(file, rank).pieceName.equals("King")) {
                WKimage.paintIcon(this, g, file, rank);
            }
            if (chessBoard.getPiece(file, rank).pieceName.equals("Queen")) {
                WQimage.paintIcon(this, g, file, rank);
            }
            if (chessBoard.getPiece(file, rank).pieceName.equals("Bishop")) {
                WBimage.paintIcon(this, g, file, rank);
            }
            if (chessBoard.getPiece(file, rank).pieceName.equals("Horse")) {
                WHimage.paintIcon(this, g, file, rank);
            }
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
