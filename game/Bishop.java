package game;
import javax.swing.ImageIcon;

/**
 *
 * @author zmaster
 */
public class Bishop extends Piece {

    final String WBISHOP_IMAGE = "resources/game/WBishop.png";//imports for the images
    ImageIcon WB_IMAGE_ICON = new ImageIcon(WBISHOP_IMAGE);//imports for the images

    final String BBISHOP_IMAGE = "resources/game/BBishop.png";//imports for the images
    ImageIcon BB_IMAGE_ICON = new ImageIcon(BBISHOP_IMAGE);//imports for the images

    public static final String BISHOP = "Bishop";
    //Aspects of the bishop
    public Bishop(boolean black, boolean firstMove) {
        super(black, BISHOP, firstMove);
    }

    //For identifing the piece for images
    @Override
    public ImageIcon getImageIcon() {
        if (isBlack()) {
            return BB_IMAGE_ICON;
        } else {
            return WB_IMAGE_ICON;
        }
    }

    //This methhot dictates what the valid move are for this piece
    @Override
    public boolean validMove() {    
        // Check if the bishop is moving diagonally
        if (Math.abs(ChessBoard.changeInRank) == Math.abs(ChessBoard.changeInFile)) {
            int rankDirection = (ChessBoard.changeInRank > 0) ? 1 : -1;
            int fileDirection = (ChessBoard.changeInFile > 0) ? 1 : -1;
            for (int i = 1; i < Math.abs(ChessBoard.changeInRank); i++) {
                int rankToCheck = ChessBoard.rankClickedOn + i * rankDirection;
                int fileToCheck = ChessBoard.fileClickedOn + i * fileDirection;
                if (ChessBoard.getPieceAtFileRank(fileToCheck, rankToCheck) != null) {
                    ChessBoard.pieceInTheWay = true;
                    break; // A piece is in the way, stop checking
                } else {
                    ChessBoard.pieceInTheWay = false;
                }
            }        
        }
        if(ChessBoard.pieceInTheWay == false){            
            return Math.abs(ChessBoard.changeInRank) == Math.abs(ChessBoard.changeInFile);
        }else{            
            return false;
        }
    }

}