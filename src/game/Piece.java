package game;

import static game.ChessBoard.getPiece;
import javax.swing.ImageIcon;

/**
 *
 * @author zmaster
 *
 * click y is first click py is where it wants to go first click sets orgin y
 * click y is where it is py is where it wants to be delta Y is change in Y
 * Check if there are same team pieces between the orgin Y and py using delta Y
 * and enemy pieces pawn delta Y is the change from orgin y to py all the pieces
 * in piece class so they have all proprtys applied to them the pieces are
 * detirminded by their piece name which is set in chessboard list instead of an
 * array? array might work so no need to change?
 *
 *
 */
public abstract class Piece {

    private String pieceName = "";//Defualt name for all squares so that they dont return null
    private boolean black;//true for black else white    

    public Piece(boolean isBlack, String pieceName) {
        this.black = isBlack;
        this.pieceName = pieceName;
    }
    
    public abstract ImageIcon getImageIcon();

    //TODO 5:
    //TODO:Piece should have starting rank and starting file?. Mabey do if i have time
    //TODO:Make abstract
    //TODO:Will need more function pramaters for validMove to calculate a valid move
    public abstract boolean validMove();

    //TODO:Implement?
    //public void validMoves() {
      //  return;
    // }

    public boolean isBlack() {
        return black;
    }

    public boolean isWhite() {
        return !black;
    }

    public String getPieceName() {
        return pieceName;
    }

    @Override
    public String toString() {
        return "Piece{" + "pieceName = " + pieceName + '}';
    }

}
