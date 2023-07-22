package game;

import static game.ChessBoard.getPiece;
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

//    int rookRank = 7;
//    int rookFile = 7;

    public Rook(boolean black) {
        super(black, ROOK);
    }

    @Override
    public ImageIcon getImageIcon() {
        if (isBlack()) {
            return BR_IMAGE_ICON;
        } else {
            return WR_IMAGE_ICON;
        }
    }

//    public void validMoves() {
//        getPiece(rookFile, rookRank);
//    }

    @Override
    public boolean validMove() {
        return ChessBoard.changeInRank == 0 || ChessBoard.changeInFile == 0;
        
        //for check do same thign as way of printing images
        //ask dad about override
    }
}
