package game;
import javax.swing.ImageIcon;

/**
 *
 * @author zmaster
 *
 */
public abstract class Piece {

    private String pieceName = "";//Defualt name for all squares so that they dont return null
    private boolean black;//true for black else white
    public boolean firstMove = true;

    public Piece(boolean isBlack, String pieceName, boolean firstMove) {
        this.black = isBlack;
        this.pieceName = pieceName;
        this.firstMove = firstMove;
    }
    
    public abstract ImageIcon getImageIcon();

    public abstract boolean validMove();

    public boolean isBlack() {
        return black;
    }

    public boolean isWhite() {
        return !black;
    }

    public String getPieceName() {
        return pieceName;
    }
    
    public boolean getFirstMove() {
        return firstMove;
    }

    @Override
    public String toString() {
        return "Piece{" + "pieceName = " + pieceName + '}';
    }

}
