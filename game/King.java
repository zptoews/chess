package game;
import javax.swing.ImageIcon;
/**
 *
 * @author zmaster
 * This class hold all the information about kings
 * 
 */
public class King extends Piece {

    final String WKING_IMAGE = "resources/game/WKing.png";//imports for the images
    ImageIcon WK_IMAGE_ICON = new ImageIcon(WKING_IMAGE);//imports for the images

    final String BKING_IMAGE = "resources/game/BKing.png";//imports for the images
    ImageIcon BK_IMAGE_ICON = new ImageIcon(BKING_IMAGE);//imports for the images
    
    public static final String KING = "King";
    
    private static final int NORMAL_KING_MOVE = 1;
    //Aspects of the king
    public King(boolean black, boolean firstMove) {
        super(black, KING, firstMove);
    }
    
    //For identifing the piece for images
    @Override
    public ImageIcon getImageIcon() {
        if (isBlack()) {
            return BK_IMAGE_ICON;
        } else {
            return WK_IMAGE_ICON;
        }
    }

    @Override
    public boolean validMove() {
        //This methhot dictates what the valid move are for this piece
        return Math.abs(ChessBoard.changeInRank) == NORMAL_KING_MOVE && 
                Math.abs(ChessBoard.changeInFile) == NORMAL_KING_MOVE || 
                Math.abs(ChessBoard.changeInFile) == NORMAL_KING_MOVE && 
                ChessBoard.changeInRank == ChessBoard.NO_CHANGE_IN_RANK || 
                Math.abs(ChessBoard.changeInRank) == NORMAL_KING_MOVE && 
                ChessBoard.changeInFile == ChessBoard.NO_CHANGE_IN_FILE; 
    }
}
