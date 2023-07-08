package gui;

import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.Graphics;
import javax.swing.*;
import game.*;

/**
 *
 * @author zmaster
 */
public class Square extends JPanel implements MouseListener {

    private static int NO_CLICK = 0;
    private static int FIRST_CLICK = 1;
    private static int SECOND_CLICK = 2;
    public int file;//global to class file variable
    public int rank;//global to class rank variable
    Piece pieceInSquare = null;
    static int clickNumber = NO_CLICK;
    static Piece pieceClickedOn = null;
    static int fileClickedOn = 0;
    static int rankClickedOn = 0;
    public static boolean validMove = true;

    public Square(int file, int rank, Piece pieceInSquare) {
        this.file = file;
        this.rank = rank;

        this.pieceInSquare = pieceInSquare;

        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        //TODO 2: Turns
        //TODO 3: Make pieces not take their same team colour
        //TODO 4: Valid turns

        System.out.println(" " + file + " " + rank);//to tell the rank and file of the square clicked
        //chessBoard.getPiece(file, rank);
        if (ChessBoard.getPiece(file, rank) != null) {
            System.out.println("There is piece here");
        }
        clickNumber++;//adding to the clicks
        System.out.println("" + clickNumber + "");
        if (clickNumber == FIRST_CLICK) {
            System.out.println("First click");

            //remeber what piece is clicked on
            pieceClickedOn = ChessBoard.getPiece(file, rank);

            //tracks first move
            fileClickedOn = file;
            rankClickedOn = rank;
        }

        if (clickNumber == SECOND_CLICK) {
            System.out.println("Second click");
            System.out.println("remembered piece is " + pieceClickedOn + "");
            clickNumber = NO_CLICK;

            //change were the pieces are the chess board
            //use setPiece
            if (pieceClickedOn != null) {
                //TODO:if valid move is true then do move
                if (validMove == true) {
                    ChessBoard.setPiece(file, rank, pieceClickedOn);
                    ChessBoard.setPiece(fileClickedOn, rankClickedOn, null);
                }
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        Piece piece = ChessBoard.getPiece(file, rank);

        if (piece != null) {
            //To print out the correct images for the pieces            
            if (piece.getPieceName().equals(Pawn.PAWN) && piece.isWhite()) {
                piece.getImageIcon().paintIcon(this, g, file, rank);
            }
            //To print out the correct images for the pieces  
            if (piece.getPieceName().equals(King.KING) && piece.isWhite()) {
                piece.getImageIcon().paintIcon(this, g, file, rank);
            }
            //To print out the correct images for the pieces  
            if (piece.getPieceName().equals(Queen.QUEEN) && piece.isWhite()) {
                piece.getImageIcon().paintIcon(this, g, file, rank);
            }
            //To print out the correct images for the pieces  
            if (piece.getPieceName().equals(Bishop.BISHOP) && piece.isWhite()) {
                piece.getImageIcon().paintIcon(this, g, file, rank);
            }
            //To print out the correct images for the pieces  
            if (piece.getPieceName().equals(Horse.HORSE) && piece.isWhite()) {
                piece.getImageIcon().paintIcon(this, g, file, rank);
            }
            //To print out the correct images for the pieces  
            if (piece.getPieceName().equals(Rook.ROOK) && piece.isWhite()) {
                piece.getImageIcon().paintIcon(this, g, file, rank);
            }
            if (piece.getPieceName().equals(Pawn.PAWN) && piece.isBlack()) {
                piece.getImageIcon().paintIcon(this, g, file, rank);
            }
            //To print out the correct images for the pieces  
            if (piece.getPieceName().equals(King.KING) && piece.isBlack()) {
                piece.getImageIcon().paintIcon(this, g, file, rank);
            }
            //To print out the correct images for the pieces  
            if (piece.getPieceName().equals(Queen.QUEEN) && piece.isBlack()) {
                piece.getImageIcon().paintIcon(this, g, file, rank);
            }
            //To print out the correct images for the pieces  
            if (piece.getPieceName().equals(Bishop.BISHOP) && piece.isBlack()) {
                piece.getImageIcon().paintIcon(this, g, file, rank);
            }
            //To print out the correct images for the pieces  
            if (piece.getPieceName().equals(Horse.HORSE) && piece.isBlack()) {
                piece.getImageIcon().paintIcon(this, g, file, rank);
            }
            //To print out the correct images for the pieces  
            if (piece.getPieceName().equals(Rook.ROOK) && piece.isBlack()) {
                piece.getImageIcon().paintIcon(this, g, file, rank);
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
