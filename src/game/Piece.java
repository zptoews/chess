package game;

import static game.ChessBoard.getPiece;

/**
 * 
 * @author zmaster
 * 
 * orgin y is first click
 * py is where it wants to go
 * first click sets orgin y
 * orgin y is where it is
 * py is where it wants to be
 * delta Y is change in Y
 * Check if there are same team pieces between the orgin Y and py using delta Y
 * and enemy pieces pawn
 * delta Y is the change from orgin y to py
 * all the pieces in piece class so they have all proprtys applied to them
 * the pieces are detirminded by their piece name which is set in chessboard
 * list instead of an array?
 * array might work so no need to change?
 * 
 * 
 */
public class Piece {

    private String pieceName = "";//Defualt name for all squares so that they dont return null
    private boolean black;//true for black else white
    //Make images be a propty of piece?

    public Piece(boolean isBlack, String pieceName) {
        this.black = isBlack;
        this.pieceName = pieceName;
    }
    
    //TODO:Piece should have starting rank and starting file 
    //TODO:Make abstract
    //TODO:Will need more function pramaters for validMove to calculate a valid move
    public boolean validMove() {
        return true;
    }
    //TODO:Implement?
    public void validMoves(){
      return;
    }
    
    public boolean isBlack() {
        return black;
    }
    
    public boolean isWhite(){
        return !black;
    }
    
    public String getPieceName(){
        return pieceName;
    }
    
    @Override
    public String toString() {
        return "Piece{" + "pieceName = " + pieceName + '}';
    }

}
