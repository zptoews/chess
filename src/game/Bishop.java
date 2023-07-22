package game;

import static game.ChessBoard.getPiece;
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

//    int bishopRank = 0;
//    int bishopFile = 0;

    public Bishop(boolean black) {
        super(black, BISHOP);
    }

    @Override
    public ImageIcon getImageIcon() {
        if (isBlack()) {
            return BB_IMAGE_ICON;
        } else {
            return WB_IMAGE_ICON;
        }
    }

//    public void validMoves() {
//        getPiece(bishopFile, bishopRank);
//    }

    @Override
    public boolean validMove() {
        return Math.abs(ChessBoard.changeInRank) == Math.abs(ChessBoard.changeInFile);
    }
}
