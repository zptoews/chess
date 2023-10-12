package gui;

import game.ChessBoard;

/**
 *
 * @author zmaster
 * This class makes the game appere
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
