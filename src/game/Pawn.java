package game;

/**
 *
 * @author zmaster
 *
 * This class holds information about pawns
 *
 */
import static game.ChessBoard.getPiece;
import javax.swing.ImageIcon;

public class Pawn extends Piece {

    private final String WPAWN_IMAGE = "resources/game/WPrawn.png";
    private final ImageIcon WP_IMAGE_ICON = new ImageIcon(WPAWN_IMAGE);//imports for the images

    private final String BPAWN_IMAGE = "resources/game/BPrawn.png";//imports for the images
    private final ImageIcon BP_IMAGE_ICON = new ImageIcon(BPAWN_IMAGE);//imports for the images

    public static final String PAWN = "Pawn";

    private static final int NORMAL_PAWN_MOVE = 1;

//    int pawnRank = 0;
//    int pawnFile = 0;
    public Pawn(boolean black) {
        super(black, PAWN);
    }

    @Override
    public ImageIcon getImageIcon() {
        if (isBlack()) {
            return BP_IMAGE_ICON;
        } else {
            return WP_IMAGE_ICON;
        }
    }

    //TODO:Valid moves, return a boolean
//    public void validMoves() {
//        getPiece(pawnFile, pawnRank);
//    }
    @Override
    public boolean validMove() {
        return Math.abs(ChessBoard.changeInRank) == NORMAL_PAWN_MOVE && 
                ChessBoard.changeInFile == ChessBoard.NO_CHANGE_IN_FILE;
    }

}
