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

    private int file;//global to class file variable
    private int rank;//global to class rank variable

    public Square(int file, int rank, Piece pieceInSquare) {
        this.file = file;
        this.rank = rank;

        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        //TODO 3: Make pieces not take their same team colour
        //TODO 4: Valid turns

        Piece piece = ChessBoard.getPiece(file, rank);
        //made the first click outside turn logic because it is the first click then move with the second click
        ChessBoard.clickNumber++;//adding to the clicks
        if (ChessBoard.clickNumber == ChessBoard.FIRST_CLICK) {
            System.out.println("First click");

            //remeber what piece is clicked on
            ChessBoard.pieceClickedOn = ChessBoard.getPiece(file, rank);

            //tracks first move
            ChessBoard.fileClickedOn = file;
            ChessBoard.rankClickedOn = rank;
        }

        if (ChessBoard.blackTurn && ChessBoard.pieceClickedOn != null && ChessBoard.pieceClickedOn.isBlack()) {

            if (ChessBoard.clickNumber == ChessBoard.SECOND_CLICK) {

                //selected = getPiece();
                //selected.move();
                System.out.println("black Second click");
                System.out.println("remembered piece is black " + ChessBoard.pieceClickedOn + "");
                ChessBoard.clickNumber = ChessBoard.NO_CLICK;

                //change were the pieces are the chess board
                //use setPiece
                //TODO:if valid move is true then do move
                if (ChessBoard.validMove(file, rank, ChessBoard.pieceClickedOn)) {
                    ChessBoard.setPiece(file, rank, ChessBoard.pieceClickedOn);
                    ChessBoard.setPiece(ChessBoard.fileClickedOn, ChessBoard.rankClickedOn, null);
                    ChessBoard.blackTurn = false;
                }

            }
        } else if (ChessBoard.blackTurn == false && ChessBoard.pieceClickedOn != null && ChessBoard.pieceClickedOn.isWhite()) {

            if (ChessBoard.clickNumber == ChessBoard.SECOND_CLICK) {
                System.out.println("white Second click");
                System.out.println("remembered piec e is  white " + ChessBoard.pieceClickedOn + "");
                ChessBoard.clickNumber = ChessBoard.NO_CLICK;

                //change were the pieces are the chess board
                //use setPiece
                //TODO:if valid move is true then do move
                if (ChessBoard.validMove(file, rank, ChessBoard.pieceClickedOn)) {
                    ChessBoard.setPiece(file, rank, ChessBoard.pieceClickedOn);
                    ChessBoard.setPiece(ChessBoard.fileClickedOn, ChessBoard.rankClickedOn, null);
                    ChessBoard.blackTurn = true;
                }

            }
        } else {
            System.out.println("Not your turn");
            ChessBoard.clickNumber = ChessBoard.NO_CLICK;
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
