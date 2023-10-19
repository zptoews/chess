package game;

import gui.Square;

/**
 *
 * @author Zachary Toews
 *
 * This is the code that defines what the board is and how things on it can be
 * manipulated as well as the condition that the board starts in.
 *
 */
public class ChessBoard {

    //Making the board of pieces
    public static final int NO_CLICK = 0;
    public static final int FIRST_CLICK = 1;
    public static final int SECOND_CLICK = 2;
    public static final boolean BLACK = true;
    public static final boolean WHITE = false;
    public static final int NO_CHANGE_IN_FILE = 0;
    public static final int NO_CHANGE_IN_RANK = 0;

    public static Piece board[][] = new Piece[8][8];

    public static boolean blackTurn = false;
    public static int fileClickedOn = 0;
    public static int rankClickedOn = 0;
    public static Piece pieceClickedOn = null;
    public static int clickNumber = NO_CLICK;
    public static int changeInFile;
    public static int changeInRank;
    //public static int startingFile = 0;
    //public static int startingRank = 0;
    public static boolean pieceInTheWay = true;
    public boolean firstMove = true;
    public static int cFile;
    public static int cRank;

    public ChessBoard() {
        //Placing the black pieces in the board
        board[0][1] = new Pawn(BLACK, firstMove);
        board[1][1] = new Pawn(BLACK, firstMove);
        board[2][1] = new Pawn(BLACK, firstMove);
        board[3][1] = new Pawn(BLACK, firstMove);
        board[4][1] = new Pawn(BLACK, firstMove);
        board[5][1] = new Pawn(BLACK, firstMove);
        board[6][1] = new Pawn(BLACK, firstMove);
        board[7][1] = new Pawn(BLACK, firstMove);
        board[0][0] = new Rook(BLACK, firstMove);
        board[1][0] = new Horse(BLACK, firstMove);
        board[2][0] = new Bishop(BLACK, firstMove);
        board[3][0] = new Queen(BLACK, firstMove);
        board[4][0] = new King(BLACK, firstMove);
        board[5][0] = new Bishop(BLACK, firstMove);
        board[6][0] = new Horse(BLACK, firstMove);
        board[7][0] = new Rook(BLACK, firstMove);

        //Placing the black pieces in the board
        board[0][6] = new Pawn(WHITE, firstMove);
        board[1][6] = new Pawn(WHITE, firstMove);
        board[2][6] = new Pawn(WHITE, firstMove);
        board[3][6] = new Pawn(WHITE, firstMove);
        board[4][6] = new Pawn(WHITE, firstMove);
        board[5][6] = new Pawn(WHITE, firstMove);
        board[6][6] = new Pawn(WHITE, firstMove);
        board[7][6] = new Pawn(WHITE, firstMove);
        board[0][7] = new Rook(WHITE, firstMove);
        board[1][7] = new Horse(WHITE, firstMove);
        board[2][7] = new Bishop(WHITE, firstMove);
        board[3][7] = new Queen(WHITE, firstMove);
        board[4][7] = new King(WHITE, firstMove);
        board[5][7] = new Bishop(WHITE, firstMove);
        board[6][7] = new Horse(WHITE, firstMove);
        board[7][7] = new Rook(WHITE, firstMove);
    }

    public static Piece getPiece(int file, int rank) {
        //This methood returns the location file and rank of a piece
        changeInFile = file - fileClickedOn;
        changeInRank = rank - rankClickedOn;
        cFile = file;
        cRank = rank;
        return board[file][rank];
    }

    public static Piece getPieceAtFileRank(int pieceFile, int pieceRank) {
        return board [pieceFile][pieceRank];
    }

    public int getFileOfPiece(Piece p){
        //This methood gets the file of a piece
        for(int f = 0; f < 8; f++){
            for(int r = 0; r < 8; r++){
                if(board[f][r] == p){
                    return f;
                }
            }
        }
        return 0;
    }

    public int getRankOfPiece(Piece p){
        //This methood gets the rank of a piece
        for(int f = 0; f < 8; f++){
            for(int r = 0; r < 8; r++){
                if(board[f][r] == p){
                    return r;
                }
            }
        }
        return 0;
    }

    public static void setPiece(int file, int rank, Piece piece) {
        //This methood set's the piece's location
        board[file][rank] = piece;
    }

    public static boolean validMove(int fileClickedOn, int rankClickedOn, Piece firstPieceClickedOn) {
        //This methood checks if the move perforemd on a piece is valid, and if it isnt the it denys the move. 
        //This also check to make sure a piece from one team takes the same team piece
        Piece secondPieceClickedOn = getPiece(fileClickedOn, rankClickedOn);
        System.out.println("Change in file is "+ ChessBoard.changeInFile);
        System.out.println("Change in rank is "+ ChessBoard.changeInRank);  
        if (secondPieceClickedOn != null && firstPieceClickedOn.isBlack() && secondPieceClickedOn.isBlack()) {
            return false;
        } else if (secondPieceClickedOn != null && firstPieceClickedOn.isWhite() && secondPieceClickedOn.isWhite()) {
            return false;
        } else if (firstPieceClickedOn.validMove() && firstPieceClickedOn.isBlack() && firstPieceClickedOn.getPieceName().equals(Pawn.PAWN) && changeInRank < 0) {
            System.out.println("invalid move for black " + firstPieceClickedOn);
            return false;
        }else if (firstPieceClickedOn.validMove() && firstPieceClickedOn.isWhite() && firstPieceClickedOn.getPieceName().equals(Pawn.PAWN) && changeInRank > 0) {
            System.out.println("invalid move for white " + firstPieceClickedOn);
            return false;
        }else if (firstPieceClickedOn.validMove()) {
            return true;
        } else {
            System.out.println("invalid move for " + firstPieceClickedOn);
            return false;
        }
    }

}
