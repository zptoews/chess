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

    public Pawn(boolean black, boolean firstMove) {
        super(black, PAWN, firstMove);
    }

    @Override
    public ImageIcon getImageIcon() {
        if (isBlack()) {
            return BP_IMAGE_ICON;
        } else {
            return WP_IMAGE_ICON;
        }
    }
    
    @Override
    public boolean validMove() {
        if (firstMove) {
            if (Math.abs(ChessBoard.changeInRank) == NORMAL_FIRST_PAWN_MOVE
                    && ChessBoard.changeInFile == ChessBoard.NO_CHANGE_IN_FILE) {
                firstMove = false;
                return true;
            } else if (Math.abs(ChessBoard.changeInRank) == NORMAL_PAWN_MOVE
                    && ChessBoard.changeInFile == ChessBoard.NO_CHANGE_IN_FILE) {
                firstMove = false;
                return true;
            } else {
                return false;
            }
        } else {
            return Math.abs(ChessBoard.changeInRank) == NORMAL_PAWN_MOVE
                    && ChessBoard.changeInFile == ChessBoard.NO_CHANGE_IN_FILE;
        }
    }

}
