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
    
    //Making the board of pieces
    Piece board[][] = new Piece[8][8];

    public ChessBoard() {
        //Placing the pieces in the board
        board[6][0] = new Pawn();
        board[6][1] = new Pawn();
        board[6][2] = new Pawn();
        board[6][3] = new Pawn();
        board[6][4] = new Pawn();
        board[6][5] = new Pawn();
        board[6][6] = new Pawn();
        board[6][7] = new Pawn();
        board[7][0] = new Rook();
        board[7][1] = new Horse();
        board[7][2] = new Bishop();
        board[7][3] = new Queen();
        board[7][4] = new King();
        board[7][5] = new Bishop();
        board[7][6] = new Horse();
        board[7][7] = new Rook();
    }
    
    
    public Piece getPiece(int file, int rank) {//returning the location file and rank of a piece
        return board[file][rank];
    }
}
