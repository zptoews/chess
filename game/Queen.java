package game;
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
    //Aspects of the queen
    public Queen(boolean black, boolean firstMove) {
        super(black, QUEEN, firstMove);
    }

    //For identifing the piece for images
    @Override
    public ImageIcon getImageIcon() {
        if (isBlack()) {
            return BQ_IMAGE_ICON;
        } else {
            return WQ_IMAGE_ICON;
        }
    }

    @Override
    public boolean validMove() {
        //This methhot dictates what the valid move are for this piece
        int directionRank = 0;
        int directionFile = 0;
        ChessBoard.pieceInTheWay = false;

        if(ChessBoard.changeInFile == 0){
            if(ChessBoard.changeInRank > 0){
                directionRank = 1;
            }else{
                directionRank = -1;
            }
        }else{
            if(ChessBoard.changeInFile > 0){
                directionFile = 1;
            }else{
                directionFile = -1;
            }
        }                   
        if(ChessBoard.changeInRank > 0 && ChessBoard.changeInFile == 0){//Walking down the ranks looking for pieces           
            for(int qRank = ChessBoard.rankClickedOn + 1; qRank != (ChessBoard.rankClickedOn + ChessBoard.changeInRank); qRank += directionRank){             
                if(ChessBoard.getPieceAtFileRank(ChessBoard.fileClickedOn,qRank) != null){
                    ChessBoard.pieceInTheWay = true;
                }else{
                    ChessBoard.pieceInTheWay = false;
                }          
            }
        }else if(ChessBoard.changeInRank < 0 && ChessBoard.changeInFile == 0){
            for(int qRank = ChessBoard.rankClickedOn -1; qRank != (ChessBoard.rankClickedOn + ChessBoard.changeInRank); qRank += directionRank){                
                if(ChessBoard.getPieceAtFileRank(ChessBoard.fileClickedOn,qRank) != null){
                    ChessBoard.pieceInTheWay = true;
                }else{
                    ChessBoard.pieceInTheWay = false;
                }        
            }
        }else if(ChessBoard.changeInFile > 0 && ChessBoard.changeInRank == 0){
            for(int qFile = ChessBoard.fileClickedOn +1; qFile != (ChessBoard.fileClickedOn + ChessBoard.changeInFile); qFile += directionFile){
                if(ChessBoard.getPieceAtFileRank(qFile,ChessBoard.rankClickedOn) != null){
                    ChessBoard.pieceInTheWay = true;
                }else{                    
                    ChessBoard.pieceInTheWay = false;
                }
            }
        }else if(ChessBoard.changeInFile < 0 && ChessBoard.changeInRank == 0){
            for(int qFile = ChessBoard.fileClickedOn -1; qFile != (ChessBoard.fileClickedOn + ChessBoard.changeInFile); qFile += directionFile){                
                if(ChessBoard.getPieceAtFileRank(qFile,ChessBoard.rankClickedOn) != null){                      
                    ChessBoard.pieceInTheWay = true;
                }else{
                    ChessBoard.pieceInTheWay = false;
                }    
            }
        }else{
            
        }
        if (Math.abs(ChessBoard.changeInRank) == Math.abs(ChessBoard.changeInFile)) {
            int rankDirection = (ChessBoard.changeInRank > 0) ? 1 : -1;
            int fileDirection = (ChessBoard.changeInFile > 0) ? 1 : -1;
            for (int i = 1; i < Math.abs(ChessBoard.changeInRank); i++) {
                int rankToCheck = ChessBoard.rankClickedOn + i * rankDirection;
                int fileToCheck = ChessBoard.fileClickedOn + i * fileDirection;            
                if (ChessBoard.getPieceAtFileRank(fileToCheck, rankToCheck) != null) {
                    ChessBoard.pieceInTheWay = true;
                    break; //A piece is in the way so stop checking
                } else {
                    ChessBoard.pieceInTheWay = false;
                }
            }        
        }
        if(ChessBoard.pieceInTheWay == false){            
            return ChessBoard.changeInRank == ChessBoard.NO_CHANGE_IN_RANK || 
            ChessBoard.changeInFile == ChessBoard.NO_CHANGE_IN_FILE || Math.abs(ChessBoard.changeInRank) == Math.abs(ChessBoard.changeInFile);
        }else{            
            return false;
        }
    }
}
