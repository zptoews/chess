package game;

import static game.ChessBoard.getPiece;
import javax.swing.ImageIcon;

/**
 *
 * @author zmaster
 */
public class Horse extends Piece {

    final String WHORSE_IMAGE = "resources/game/WHorse.png";//imports for the images
    ImageIcon WH_IMAGE_ICON = new ImageIcon(WHORSE_IMAGE);//imports for the images

    final String BHORSE_IMAGE = "resources/game/BHorse.png";//imports for the images
    ImageIcon BH_IMAGE_ICON = new ImageIcon(BHORSE_IMAGE);//imports for the images
    
    public static final String HORSE = "Horse";

//    int horseRank = 0;
//    int horseFile = 0;

    public Horse(boolean black) {
        super(black, HORSE);
    }

    @Override
    public ImageIcon getImageIcon() {
        if (isBlack()) {
            return BH_IMAGE_ICON;
        } else {
            return WH_IMAGE_ICON;
        }
    }

//    public void validMoves() {
//        getPiece(horseFile, horseRank);
//    }

    @Override
    public boolean validMove() {
        return true;
    }
}
