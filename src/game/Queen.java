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
    int queenRank = 0;
    int queenFile = 0;
    public Queen(){
    pieceName = "Queen";//Setting the pieces name
}
    public void validMoves(){
        getPiece(queenFile, queenRank);
    }
    @Override
    public boolean validMove(){
        return true;
    }
}
