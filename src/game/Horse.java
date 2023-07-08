/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import static game.ChessBoard.getPiece;

/**
 *
 * @author zmaster
 */
public class Horse extends Piece {
    
    public static final String HORSE = "Horse";

    int horseRank = 0;
    int horseFile = 0;

    public Horse(boolean black) {
        super(black,HORSE);        
    }

    public void validMoves() {
        getPiece(horseFile, horseRank);
    }

    @Override
    public boolean validMove() {
        return true;
    }
}
