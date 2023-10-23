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
    //Aspects of the rook
    public Rook(boolean black, boolean firstMove) {
        super(black, ROOK, firstMove);
    }

    //For identifing the piece for images
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
            for(int rRank = ChessBoard.rankClickedOn + 1; rRank != (ChessBoard.rankClickedOn + ChessBoard.changeInRank); rRank += directionRank){             
                if(ChessBoard.getPieceAtFileRank(ChessBoard.fileClickedOn,rRank) != null){
                    ChessBoard.pieceInTheWay = true;
                }else{
                    ChessBoard.pieceInTheWay = false;
                }          
            }
        }else if(ChessBoard.changeInRank < 0 && ChessBoard.changeInFile == 0){
            for(int rRank = ChessBoard.rankClickedOn -1; rRank != (ChessBoard.rankClickedOn + ChessBoard.changeInRank); rRank += directionRank){                
                if(ChessBoard.getPieceAtFileRank(ChessBoard.fileClickedOn,rRank) != null){
                    ChessBoard.pieceInTheWay = true;
                }else{
                    ChessBoard.pieceInTheWay = false;
                }        
            }
        }else if(ChessBoard.changeInFile > 0 && ChessBoard.changeInRank == 0){
            for(int rFile = ChessBoard.fileClickedOn +1; rFile != (ChessBoard.fileClickedOn + ChessBoard.changeInFile); rFile += directionFile){
                if(ChessBoard.getPieceAtFileRank(rFile,ChessBoard.rankClickedOn) != null){
                    ChessBoard.pieceInTheWay = true;
                }else{                    
                    ChessBoard.pieceInTheWay = false;
                }
            }
        }else if(ChessBoard.changeInFile < 0 && ChessBoard.changeInRank == 0){
            for(int rFile = ChessBoard.fileClickedOn -1; rFile != (ChessBoard.fileClickedOn + ChessBoard.changeInFile); rFile += directionFile){                
                if(ChessBoard.getPieceAtFileRank(rFile,ChessBoard.rankClickedOn) != null){                      
                    ChessBoard.pieceInTheWay = true;
                }else{
                    ChessBoard.pieceInTheWay = false;
                }    
            }
        }else{
            
        }
        if(ChessBoard.pieceInTheWay == false){            
            return ChessBoard.changeInRank == ChessBoard.NO_CHANGE_IN_RANK || 
            ChessBoard.changeInFile == ChessBoard.NO_CHANGE_IN_FILE;
        }else{            
            return false;
        }
    }
}