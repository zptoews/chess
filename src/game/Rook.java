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

    int rookRank = 7;
    int rookFile = 7;

    public Rook() {
        pieceName = "Rook";//Setting the pieces name

    }

    public void validMoves() {
        getPiece(rookFile, rookRank);
    }

    @Override
    public boolean validMove() {
        return true;
    }
}
