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
        //checking of there is a piece infront of the black pawn
        if(Math.abs(ChessBoard.changeInRank) == NORMAL_FIRST_PAWN_MOVE
        && ChessBoard.changeInFile == ChessBoard.NO_CHANGE_IN_FILE && ChessBoard.changeInRank > 0){            
            if(ChessBoard.getPieceAtFileRank(ChessBoard.fileClickedOn, ChessBoard.rankClickedOn + 1) == null){            
                return false;
            } else {
                return true;
            }
        } 
        //checking if there is a piece infront of the white pawn
        else if(Math.abs(ChessBoard.changeInRank) == NORMAL_FIRST_PAWN_MOVE
        && ChessBoard.changeInFile == ChessBoard.NO_CHANGE_IN_FILE && ChessBoard.changeInRank < 0){            
            if(ChessBoard.getPieceAtFileRank(ChessBoard.fileClickedOn, ChessBoard.rankClickedOn - 1) == null){            
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        } 
    }

    @Override
    public boolean validMove() {
        //This method dictates what the valid move are for this piece
        int rankDirection = (ChessBoard.changeInRank > 0) ? 1 : -1;
        int fileDirection = (ChessBoard.changeInFile > 0) ? 1 : -1;
        /*
        boolean positiveRank;
        boolean positiveFile;

        if(rankDirection > 0){positiveRank = true;}else{positiveRank = false;}
        if(fileDirection > 0){positiveFile = true;}else{positiveFile = false;}
         */
        if (firstMove) {            
            if (pawnObstructed() == false) {
                firstMove = false;
                return true;
            } else if (Math.abs(ChessBoard.changeInRank) == NORMAL_PAWN_MOVE
            && ChessBoard.changeInFile == ChessBoard.NO_CHANGE_IN_FILE) {
                firstMove = false;
                return true;
            } else if(ChessBoard.getPieceAtFileRank(ChessBoard.fileClickedOn + fileDirection, ChessBoard.rankClickedOn + rankDirection) != null){
                firstMove = false;
                return true;
            } else{
                return false;
            }
        } else {
            if(Math.abs(ChessBoard.changeInRank) == NORMAL_PAWN_MOVE && ChessBoard.changeInFile == ChessBoard.NO_CHANGE_IN_FILE){
                return true;
            } else if(ChessBoard.getPieceAtFileRank(ChessBoard.fileClickedOn + fileDirection, ChessBoard.rankClickedOn + rankDirection) != null){
                return true;
            } else {
                return false;
            }
        }
    }

}
