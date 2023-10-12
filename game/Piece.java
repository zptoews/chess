package game;
import javax.swing.ImageIcon;

/**
 *
 * @author zmaster
 *This is the class that hold the information for the generic form of a any piece 
 *
 */
public abstract class Piece {

    private String pieceName = "";//Defualt name for all squares so that they dont return null
    private boolean black;//true for black else white
    public boolean firstMove = true;
    
    //Aspects of any piece
    public Piece(boolean isBlack, String pieceName, boolean firstMove) {
        this.black = isBlack;
        this.pieceName = pieceName;
        this.firstMove = firstMove;
    }
    
    public abstract ImageIcon getImageIcon();
    //Overiden valid move methood
    public abstract boolean validMove();
    //Checks if a piece is black
    public boolean isBlack() {
        return black;
    }
    //Checks if a piece is white
    public boolean isWhite() {
        return !black;
    }
    //Returns piece name
    public String getPieceName() {
        return pieceName;
    }
    //Returns first move
    public boolean getFirstMove() {
        return firstMove;
    }

    @Override
    public String toString() {
        return "Piece{" + "pieceName = " + pieceName + '}';
    }

}
