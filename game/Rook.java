package game;
import javax.swing.ImageIcon;

/**
 *
 * @author zmaster
 */
public class Rook extends Piece {

    final String WROOK_IMAGE = "resources/game/WCastle.png";//imports for the images
    ImageIcon WR_IMAGE_ICON = new ImageIcon(WROOK_IMAGE);//imports for the images

    final String BROOK_IMAGE = "resources/game/BCastle.png";//imports for the images
    ImageIcon BR_IMAGE_ICON = new ImageIcon(BROOK_IMAGE);//imports for the images
    
    public static final String ROOK = "Rook";

    public Rook(boolean black, boolean firstMove) {
        super(black, ROOK, firstMove);
    }

    @Override
    public ImageIcon getImageIcon() {
        if (isBlack()) {
            return BR_IMAGE_ICON;
        } else {
            return WR_IMAGE_ICON;
        }
    }
    
    @Override
    public boolean validMove() {
        return ChessBoard.changeInRank == ChessBoard.NO_CHANGE_IN_RANK || 
                ChessBoard.changeInFile == ChessBoard.NO_CHANGE_IN_FILE;
    }
}
