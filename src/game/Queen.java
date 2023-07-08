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
public class Queen extends Piece {
    
    public static final String QUEEN = "Queen";

    int queenRank = 0;
    int queenFile = 0;

    public Queen(boolean black) {
        super(black,QUEEN);       
    }

    public void validMoves() {
        getPiece(queenFile, queenRank);
    }

    @Override
    public boolean validMove() {
        return true;
    }
}
