package game;

/**
 *
 * @author Zachary Toews
 *
 * This is the code that defines what the board is and how things on it can be
 * manipulated.
 *
 */
public class ChessBoard {

    Piece board[][] = new Piece[8][8];

    public ChessBoard() {
        board[6][1] = new Pawn();
        board[6][2] = new Pawn();
    }

    public Piece getPiece(int file, int rank) {
        return board[file][rank];
    }
}
