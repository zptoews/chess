package game;
/**
 *
 * @author zmaster
 *
 * This class holds information about pawns
 *
 */
import javax.swing.ImageIcon;

public class Pawn extends Piece {

    private final String WPAWN_IMAGE = "resources/game/WPrawn.png";
    private final ImageIcon WP_IMAGE_ICON = new ImageIcon(WPAWN_IMAGE);//imports for the images

    private final String BPAWN_IMAGE = "resources/game/BPrawn.png";//imports for the images
    private final ImageIcon BP_IMAGE_ICON = new ImageIcon(BPAWN_IMAGE);//imports for the images
    public static final String PAWN = "Pawn";

    private static final int NORMAL_PAWN_MOVE = 1;
    private static final int NORMAL_FIRST_PAWN_MOVE = 2;
    //Aspects of the pawn
    public Pawn(boolean black, boolean firstMove) {
        super(black, PAWN, firstMove);
    }
    //For identifing the piece for images
    @Override
    public ImageIcon getImageIcon() {
        if (isBlack()) {
            return BP_IMAGE_ICON;
        } else {
            return WP_IMAGE_ICON;
        }
    }

    public boolean pawnObstructed(){
        //checks if the pawn is obstrcuted
        if(Math.abs(ChessBoard.changeInRank) == NORMAL_FIRST_PAWN_MOVE
        && ChessBoard.changeInFile == ChessBoard.NO_CHANGE_IN_FILE && ChessBoard.pieceClickedOn.isBlack()){
            if(ChessBoard.getPieceAtFileRank(ChessBoard.fileClickedOn, ChessBoard.rankClickedOn + 1) == null 
            && ChessBoard.getPieceAtFileRank(ChessBoard.fileClickedOn, ChessBoard.rankClickedOn + ChessBoard.changeInRank) == null){            
                return false;
            } else {
                return true;
            }
        } else if(Math.abs(ChessBoard.changeInRank) == NORMAL_FIRST_PAWN_MOVE
        && ChessBoard.changeInFile == ChessBoard.NO_CHANGE_IN_FILE && ChessBoard.pieceClickedOn.isWhite()){
            if(ChessBoard.getPieceAtFileRank(ChessBoard.fileClickedOn, ChessBoard.rankClickedOn - 1) == null
            && ChessBoard.getPieceAtFileRank(ChessBoard.fileClickedOn, ChessBoard.rankClickedOn + ChessBoard.changeInRank) == null){            
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        } 
    }

    public boolean pawnColourCheck(){
        //Checks if it is a valid direction for the pawns move
        if (ChessBoard.getPieceAtFileRank(ChessBoard.fileClickedOn, ChessBoard.rankClickedOn).isBlack() && ChessBoard.changeInRank > 0) {            
            return true;
        } else if(ChessBoard.getPieceAtFileRank(ChessBoard.fileClickedOn, ChessBoard.rankClickedOn).isWhite() && ChessBoard.changeInRank < 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean validMove() {
        //This method dictates what the valid move are for this piece
        int rankDirection = (ChessBoard.changeInRank > 0) ? 1 : -1;
        int fileDirection = (ChessBoard.changeInFile > 0) ? 1 : -1;
        System.out.println("Change in rank is : "+ChessBoard.fileClickedOn+"");
        System.out.println("File clicked on is : "+ChessBoard.fileClickedOn+"");
        if (firstMove) {
            if (pawnObstructed() == false) {
                firstMove = false;
                return true;
            } else if (pawnColourCheck() && Math.abs(ChessBoard.changeInRank) == NORMAL_PAWN_MOVE
            && ChessBoard.changeInFile == ChessBoard.NO_CHANGE_IN_FILE 
            && ChessBoard.getPieceAtFileRank(ChessBoard.fileClickedOn, ChessBoard.rankClickedOn + rankDirection) == null) {
                firstMove = false;
                return true;
            } else if(pawnColourCheck() && fileDirection == ChessBoard.changeInFile 
            && ChessBoard.getPieceAtFileRank(ChessBoard.fileClickedOn + fileDirection, ChessBoard.rankClickedOn + rankDirection) != null 
            && ChessBoard.changeInFile <= 1 && ChessBoard.changeInFile >= -1 && ChessBoard.changeInRank <= 1 && ChessBoard.changeInRank >= -1) {
                firstMove = false;
                return true;
            } else {
                return false;
            }
        } else {            
            if(pawnColourCheck() && Math.abs(ChessBoard.changeInRank) == NORMAL_PAWN_MOVE 
            && ChessBoard.changeInFile == ChessBoard.NO_CHANGE_IN_FILE && ChessBoard.fileClickedOn == ChessBoard.NO_CHANGE_IN_FILE 
            && ChessBoard.getPieceAtFileRank(ChessBoard.NO_CHANGE_IN_FILE, ChessBoard.rankClickedOn + rankDirection) != null) {
                return false;
            } else if(pawnColourCheck() && Math.abs(ChessBoard.changeInRank) == NORMAL_PAWN_MOVE && ChessBoard.changeInFile == ChessBoard.NO_CHANGE_IN_FILE 
            && ChessBoard.getPieceAtFileRank(ChessBoard.fileClickedOn, ChessBoard.rankClickedOn + rankDirection) == null) { 
                return true;
            } else if(pawnColourCheck() && fileDirection == ChessBoard.changeInFile 
            && ChessBoard.getPieceAtFileRank(ChessBoard.fileClickedOn + fileDirection, ChessBoard.rankClickedOn + rankDirection) != null 
            && ChessBoard.changeInFile <= 1 && ChessBoard.changeInFile >= -1 && ChessBoard.changeInRank <= 1 && ChessBoard.changeInRank >= -1) {                
                return true;
            } else {
                return false;
            }
        }
    }
}