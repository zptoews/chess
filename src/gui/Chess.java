package gui;

import game.ChessBoard;

/**
 *
 * @author zmaster
 * 
 * 
 * 
 */
public class Chess {
    
    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard();
        GUI gui = new GUI(chessBoard);
        gui.setVisible(true);
    }
    
}
