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
    
    private static final int NORMAL_HORSE_VALUE = 1;
    private static final int NORMAL_HORSE_SECOND_VALUE = 2;

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
        //2 bugs
        //Horse can move 1 in cardinal directions
        //Horse can move in extra big L e.g. from file 7 rank 1 to file 4 rank 3
        return Math.abs(ChessBoard.changeInFile) == NORMAL_HORSE_VALUE && 
                Math.abs(ChessBoard.changeInRank) == NORMAL_HORSE_SECOND_VALUE 
                || Math.abs(ChessBoard.changeInRank) == NORMAL_HORSE_VALUE && 
                Math.abs(ChessBoard.changeInFile) == NORMAL_HORSE_SECOND_VALUE;
    }
}
