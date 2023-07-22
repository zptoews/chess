package game;

import gui.Square;

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
    public static final int NO_CLICK = 0;
    public static final int FIRST_CLICK = 1;
    public static final int SECOND_CLICK = 2;
    public static final boolean BLACK = true;
    public static final boolean WHITE = false;

    public static Piece board[][] = new Piece[8][8];

    public static boolean blackTurn = false;
    public static int fileClickedOn = 0;
    public static int rankClickedOn = 0;
    public static Piece pieceClickedOn = null;
    public static int clickNumber = NO_CLICK;
    public static int changeInRank;
    public static int changeInFile;

    public ChessBoard() {
        //Placing the pieces in the board
        board[1][0] = new Pawn(BLACK);
        board[1][1] = new Pawn(BLACK);
        board[1][2] = new Pawn(BLACK);
        board[1][3] = new Pawn(BLACK);
        board[1][4] = new Pawn(BLACK);
        board[1][5] = new Pawn(BLACK);
        board[1][6] = new Pawn(BLACK);
        board[1][7] = new Pawn(BLACK);
        board[0][0] = new Rook(BLACK);
        board[0][1] = new Horse(BLACK);
        board[0][2] = new Bishop(BLACK);
        board[0][3] = new Queen(BLACK);
        board[0][4] = new King(BLACK);
        board[0][5] = new Bishop(BLACK);
        board[0][6] = new Horse(BLACK);
        board[0][7] = new Rook(BLACK);

        board[6][0] = new Pawn(WHITE);
        board[6][1] = new Pawn(WHITE);
        board[6][2] = new Pawn(WHITE);
        board[6][3] = new Pawn(WHITE);
        board[6][4] = new Pawn(WHITE);
        board[6][5] = new Pawn(WHITE);
        board[6][6] = new Pawn(WHITE);
        board[6][7] = new Pawn(WHITE);
        board[7][0] = new Rook(WHITE);
        board[7][1] = new Horse(WHITE);
        board[7][2] = new Bishop(WHITE);
        board[7][3] = new Queen(WHITE);
        board[7][4] = new King(WHITE);
        board[7][5] = new Bishop(WHITE);
        board[7][6] = new Horse(WHITE);
        board[7][7] = new Rook(WHITE);
    }

    public static Piece getPiece(int file, int rank) {//returning the location file and rank of a piece
        changeInRank = rank - rankClickedOn;
        changeInFile = file - fileClickedOn;
        return board[file][rank];
    }

    public static void setPiece(int file, int rank, Piece piece) {//seting the piece's location

        board[file][rank] = piece;
    }

    public static boolean validMove(int fileClickedOn, int rankClickedOn, Piece firstPieceClickedOn) {
        Piece secondPieceClickedOn = getPiece(fileClickedOn, rankClickedOn);
        if (secondPieceClickedOn != null && firstPieceClickedOn.isBlack() && secondPieceClickedOn.isBlack()) {
            return false;
        } else if (secondPieceClickedOn != null && firstPieceClickedOn.isWhite() && secondPieceClickedOn.isWhite()) {
            return false;
        } else if (firstPieceClickedOn.validMove()) {
            return true;
        } else {
            System.out.println("invalid move for " + firstPieceClickedOn);
            return false;
        }

    }

}
