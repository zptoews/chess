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
public class Bishop extends Piece {
    
    int bishopRank = 0;
    int bishopFile = 0;
    public Bishop(){
        pieceName = "Bishop";//Setting the pieces name
    }
    public void validMoves(){
        getPiece(bishopFile, bishopRank);
    }
    @Override
    public boolean validMove(){
        return true;
    }
}
