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
public class King extends Piece {
    int kingRank = 0;
    int kingFile = 0;
    public King(){
        pieceName = "King";//Setting the pieces name
    }
    public void validMoves(){
        getPiece(kingFile, kingRank);
    }
    @Override
    public boolean validMove(){
        return true;
    }
}
