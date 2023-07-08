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
public class Rook extends Piece {
    
    public static final String ROOK = "ROOK";

    int rookRank = 7;
    int rookFile = 7;

    public Rook(boolean black) {
        super(black, ROOK);        
    }

    public void validMoves() {
        getPiece(rookFile, rookRank);
    }

    @Override
    public boolean validMove() {
        return true;
    }
}
