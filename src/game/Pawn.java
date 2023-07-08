package game;

/**
 *
 * @author zmaster
 *
 * This class holds information about pawns
 *
 */
import static game.ChessBoard.getPiece;

public class Pawn extends Piece {

    public static final String PAWN = "Pawn";
    
    int pawnRank = 0;
    int pawnFile = 0;

    public Pawn(boolean black) {
        super(black, PAWN);
    }

    //TODO:Valid moves, return a boolean
    public void validMoves() {
        getPiece(pawnFile, pawnRank);
    }

    @Override
    public boolean validMove() {
        return true;
    }
}
