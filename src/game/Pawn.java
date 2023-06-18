package game;

/**
 *
 * @author zmaster
 * 
 * This class holds information about pawns
 * 
 */

import game.ChessBoard;
import static game.ChessBoard.getPiece;

public class Pawn extends Piece {
    int pawnRank = 0;
    int pawnFile = 0;
    
    public Pawn(){
    pieceName = "Pawn";//Setting the pieces name   
}
    //TODO:Valid moves, return a boolean
    public void validMoves(){
        getPiece(pawnFile, pawnRank);
    }
    @Override
    public boolean validMove(){
        return true;
    }
}