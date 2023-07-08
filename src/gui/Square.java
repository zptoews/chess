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

    final String WRook = "resources/game/WCastle.png";//imports for the images
    ImageIcon WRimage = new ImageIcon(WRook);//imports for the images

    final String BPawn = "resources/game/BPrawn.png";//imports for the images
    ImageIcon BPimage = new ImageIcon(BPawn);//imports for the images

    final String BQueen = "resources/game/BQueen.png";//imports for the images
    ImageIcon BQimage = new ImageIcon(BQueen);//imports for the images

    final String BKing = "resources/game/BKing.png";//imports for the images
    ImageIcon BKimage = new ImageIcon(BKing);//imports for the images

    final String BBishop = "resources/game/BBishop.png";//imports for the images
    ImageIcon BBimage = new ImageIcon(BBishop);//imports for the images

    final String BHorse = "resources/game/BHorse.png";//imports for the images
    ImageIcon BHimage = new ImageIcon(BHorse);//imports for the images

    final String BRook = "resources/game/BCastle.png";//imports for the images
    ImageIcon BRimage = new ImageIcon(BRook);//imports for the images

    public Square(int file, int rank, Piece pieceInSquare) {
        this.file = file;
        this.rank = rank;

        this.pieceInSquare = pieceInSquare;

        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {

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

        if (ChessBoard.getPiece(file, rank) != null) {
            //To print out the correct images for the pieces            
            if (piece.getPieceName().equals(Pawn.PAWN) && piece.isWhite()) {
                WPimage.paintIcon(this, g, file, rank);
            }
            //To print out the correct images for the pieces  
            if (piece.getPieceName().equals(King.KING) && piece.isWhite()) {
                WKimage.paintIcon(this, g, file, rank);
            }
            //To print out the correct images for the pieces  
            if (piece.getPieceName().equals(Queen.QUEEN) && piece.isWhite()) {
                WQimage.paintIcon(this, g, file, rank);
            }
            //To print out the correct images for the pieces  
            if (piece.getPieceName().equals(Bishop.BISHOP) && piece.isWhite()) {
                WBimage.paintIcon(this, g, file, rank);
            }
            //To print out the correct images for the pieces  
            if (piece.getPieceName().equals(Horse.HORSE) && piece.isWhite()) {
                WHimage.paintIcon(this, g, file, rank);
            }
            //To print out the correct images for the pieces  
            if (piece.getPieceName().equals(Rook.ROOK) && piece.isWhite()) {
                WRimage.paintIcon(this, g, file, rank);
            }
            if (piece.getPieceName().equals(Pawn.PAWN) && piece.isBlack()) {
                BPimage.paintIcon(this, g, file, rank);
            }
            //To print out the correct images for the pieces  
            if (piece.getPieceName().equals(King.KING) && piece.isBlack()) {
                BKimage.paintIcon(this, g, file, rank);
            }
            //To print out the correct images for the pieces  
            if (piece.getPieceName().equals(Queen.QUEEN) && piece.isBlack()) {
                BQimage.paintIcon(this, g, file, rank);
            }
            //To print out the correct images for the pieces  
            if (piece.getPieceName().equals(Bishop.BISHOP) && piece.isBlack()) {
                BBimage.paintIcon(this, g, file, rank);
            }
            //To print out the correct images for the pieces  
            if (piece.getPieceName().equals(Horse.HORSE) && piece.isBlack()) {
                BHimage.paintIcon(this, g, file, rank);
            }
            //To print out the correct images for the pieces  
            if (piece.getPieceName().equals(Rook.ROOK) && piece.isBlack()) {
                BRimage.paintIcon(this, g, file, rank);
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
