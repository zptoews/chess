package game;

import static game.ChessBoard.getPiece;
import javax.swing.ImageIcon;

/**
 *
 * @author zmaster
 */
public class Queen extends Piece {

    final String WQUEEN_IMAGE = "resources/game/WQueen.png";//imports for the images
    ImageIcon WQ_IMAGE_ICON = new ImageIcon(WQUEEN_IMAGE);//imports for the images

    final String BQUEEN_IMAGE = "resources/game/BQueen.png";//imports for the images
    ImageIcon BQ_IMAGE_ICON = new ImageIcon(BQUEEN_IMAGE);//imports for the images
    
    public static final String QUEEN = "Queen";

//    int queenRank = 0;
//    int queenFile = 0;

    public Queen(boolean black) {
        super(black, QUEEN);
    }

    @Override
    public ImageIcon getImageIcon() {
        if (isBlack()) {
            return BQ_IMAGE_ICON;
        } else {
            return WQ_IMAGE_ICON;
        }
    }

//    public void validMoves() {
//        getPiece(queenFile, queenRank);
//    }

    @Override
    public boolean validMove() {
        return ChessBoard.changeInRank == ChessBoard.NO_CHANGE_IN_RANK || 
                ChessBoard.changeInFile == ChessBoard.NO_CHANGE_IN_FILE || 
                Math.abs(ChessBoard.changeInRank) == Math.abs(ChessBoard.changeInFile);
    }
}
