package game;

import static game.ChessBoard.getPiece;

/**
 *
 * @author zmaster
 */
public class Piece {

    public String pieceName = "";//Defualt name for all squares so that they dont return null
    //Make images be a propty of piece?

    //TODO:Piece should also have colour, starting rank and starting file 
    //TODO:Make abstract
    //TODO:Will need more function pramaters for validMove to calculate a valid move
    public boolean validMove() {
        return true;
    }
    //TODO:Implement?
    public void validMoves(){
      return;
    }
    
    @Override
    public String toString() {
        return "Piece{" + "pieceName=" + pieceName + '}';
    }

}
