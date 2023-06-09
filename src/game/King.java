package game;

import static game.ChessBoard.getPiece;
import javax.swing.ImageIcon;

/**
 *
 * @author zmaster
 */
public class King extends Piece {

    final String WKING_IMAGE = "resources/game/WKing.png";//imports for the images
    ImageIcon WK_IMAGE_ICON = new ImageIcon(WKING_IMAGE);//imports for the images

    final String BKING_IMAGE = "resources/game/BKing.png";//imports for the images
    ImageIcon BK_IMAGE_ICON = new ImageIcon(BKING_IMAGE);//imports for the images
    
    public static final String KING = "King";

    int kingRank = 0;
    int kingFile = 0;

    public King(boolean black) {
        super(black, KING);
    }

    @Override
    public ImageIcon getImageIcon() {
        if (isBlack()) {
            return BK_IMAGE_ICON;
        } else {
            return WK_IMAGE_ICON;
        }
    }

    public void validMoves() {
        getPiece(kingFile, kingRank);
    }

    @Override
    public boolean validMove() {
        return true;
    }
}
