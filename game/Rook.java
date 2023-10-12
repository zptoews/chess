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
        //ChessBoard.startingFile = ChessBoard.changeInFile - ChessBoard.fileClickedOn;
        //ChessBoard.startingRank = ChessBoard.changeInRank - ChessBoard.rankClickedOn;
        System.out.println("change in file " + ChessBoard.changeInFile + "");
        System.out.println("change in rank " + ChessBoard.changeInRank + "");
        System.out.println("file clicked on " + ChessBoard.fileClickedOn + "");
        System.out.println("rank clicked on " + ChessBoard.rankClickedOn + "");
        //System.out.println("starting file " + ChessBoard.startingFile + "");
        //System.out.println("starting rank " + ChessBoard.startingRank + "");
        if(ChessBoard.changeInRank > 0 && ChessBoard.changeInFile == 0){//Walking down the ranks looking for pieces
            /*
            System.out.println("rank clicked in the if is " + ChessBoard.rankClickedOn + "");
            System.out.println("change in rank in the if is " + ChessBoard.changeInRank + "");
            System.out.println("change in rank + rank clicked on in the if is " + ChessBoard.rankClickedOn + ChessBoard.changeInRank + "");
            System.out.println("---------Direction rank is " + directionRank +"");
            */
            for(int rRank = ChessBoard.rankClickedOn + 1; rRank != (ChessBoard.rankClickedOn + ChessBoard.changeInRank); rRank += directionRank){
                /*
                System.out.println("++++++++++++++++++=change in rank at start is " + ChessBoard.changeInRank + "");
                System.out.println("rank clicked on + change in rank ============= " + (ChessBoard.rankClickedOn + ChessBoard.changeInRank) + ""); 
                System.out.println("==========rRank is " + rRank + "");            
                System.out.println("rank clicked on " + ChessBoard.rankClickedOn + "");
                */
                
                //System.out.println("================change in rank at the middle 5 is " + ChessBoard.changeInRank + "");  
                if(ChessBoard.getPieceAtFileRank(ChessBoard.fileClickedOn,rRank) != null){
                    //System.out.println("================change in rank at mid 7 is " + ChessBoard.changeInRank + "");  
                    ChessBoard.pieceInTheWay = true;
                    //rRank = ChessBoard.rankClickedOn + ChessBoard.changeInRank;
                }else{
                    //System.out.println("================change in rank at mid 7a is " + ChessBoard.changeInRank + "");  
                    System.out.println("rank " + rRank + " is null");
                    //ChessBoard.pieceInTheWay = false;
                }
                //System.out.println("================change in rank at end is " + ChessBoard.changeInRank + "");            
            }
        }else if(ChessBoard.changeInRank < 0 && ChessBoard.changeInFile == 0){
            for(int rRank = ChessBoard.rankClickedOn -1; rRank != (ChessBoard.rankClickedOn + ChessBoard.changeInRank); rRank += directionRank){
                /*
                System.out.println("++++++++++++++++++=change in rank at start is " + ChessBoard.changeInRank + "");
                System.out.println("rank clicked on + change in rank ============= " + (ChessBoard.rankClickedOn + ChessBoard.changeInRank) + ""); 
                System.out.println("==========rRank is " + rRank + "");            
                System.out.println("rank clicked on " + ChessBoard.rankClickedOn + "");
                */
                
                //System.out.println("================change in rank at the middle 5 is " + ChessBoard.changeInRank + "");  
                if(ChessBoard.getPieceAtFileRank(ChessBoard.fileClickedOn,rRank) != null){
                    //System.out.println("================change in rank at mid 7 is " + ChessBoard.changeInRank + "");  
                    ChessBoard.pieceInTheWay = true;
                    //rRank = ChessBoard.rankClickedOn + ChessBoard.changeInRank;
                }else{
                    //System.out.println("================change in rank at mid 7a is " + ChessBoard.changeInRank + "");  
                    System.out.println("rank " + rRank + " is null");
                    //ChessBoard.pieceInTheWay = false;
                }
                //System.out.println("================change in rank at end is " + ChessBoard.changeInRank + "");            
            }
        }else if(ChessBoard.changeInFile > 0 && ChessBoard.changeInRank == 0){
            for(int rFile = ChessBoard.fileClickedOn +1; rFile != (ChessBoard.fileClickedOn + ChessBoard.changeInFile); rFile += directionFile){
                /*
                System.out.println("++++++++++++++++++=change in rank at start is " + ChessBoard.changeInRank + "");
                System.out.println("rank clicked on + change in rank ============= " + (ChessBoard.rankClickedOn + ChessBoard.changeInRank) + ""); 
                System.out.println("==========rRank is " + rRank + "");            
                System.out.println("rank clicked on " + ChessBoard.rankClickedOn + "");
                */
                
                //System.out.println("================change in rank at the middle 5 is " + ChessBoard.changeInRank + "");  
                if(ChessBoard.getPieceAtFileRank(rFile,ChessBoard.rankClickedOn) != null){
                    //System.out.println("================change in rank at mid 7 is " + ChessBoard.changeInRank + "");  
                    ChessBoard.pieceInTheWay = true;
                    //rRank = ChessBoard.rankClickedOn + ChessBoard.changeInRank;
                }else{
                    //System.out.println("================change in rank at mid 7a is " + ChessBoard.changeInRank + "");  
                    System.out.println("rank " + rFile + " is null");
                    //ChessBoard.pieceInTheWay = false;
                }
                //System.out.println("================change in rank at end is " + ChessBoard.changeInRank + "");            
            }
        }else if(ChessBoard.changeInFile < 0 && ChessBoard.changeInRank == 0){
            for(int rFile = ChessBoard.fileClickedOn -1; rFile != (ChessBoard.fileClickedOn + ChessBoard.changeInFile); rFile += directionFile){
                /*
                System.out.println("++++++++++++++++++=change in rank at start is " + ChessBoard.changeInRank + "");
                System.out.println("rank clicked on + change in rank ============= " + (ChessBoard.rankClickedOn + ChessBoard.changeInRank) + ""); 
                System.out.println("==========rRank is " + rRank + "");            
                System.out.println("rank clicked on " + ChessBoard.rankClickedOn + "");
                */
                
                //System.out.println("================change in rank at the middle 5 is " + ChessBoard.changeInRank + "");  
                if(ChessBoard.getPieceAtFileRank(rFile,ChessBoard.rankClickedOn) != null){
                    //System.out.println("================change in rank at mid 7 is " + ChessBoard.changeInRank + "");  
                    ChessBoard.pieceInTheWay = true;
                    //rRank = ChessBoard.rankClickedOn + ChessBoard.changeInRank;
                }else{
                    //System.out.println("================change in rank at mid 7a is " + ChessBoard.changeInRank + "");  
                    System.out.println("rank " + rFile + " is null");
                    //ChessBoard.pieceInTheWay = false;
                }
                //System.out.println("================change in rank at end is " + ChessBoard.changeInRank + "");            
            }
        }else{
            System.out.println("Not a valid rook move");
        }
        /*
        if(ChessBoard.changeInFile < 0){//Walking down the files looking for pieces
        for(int rRank = ChessBoard.rankClickedOn; rRank != ChessBoard.rankClickedOn; rRank+=directionRank){
        if(ChessBoard.getPiece(ChessBoard.fileClickedOn,rRank) != null){
        ChessBoard.pieceInTheWay = true;
        }else{
        ChessBoard.pieceInTheWay = false;
        }
        }
        }else{
        for(int rFile = ChessBoard.fileClickedOn; rFile != ChessBoard.fileClickedOn; rFile+=directionFile){
        if(ChessBoard.getPiece(rFile,ChessBoard.rankClickedOn) != null){
        ChessBoard.pieceInTheWay = true;
        }else{
        ChessBoard.pieceInTheWay = false;
        }
        }
        } 
         */
        if(ChessBoard.pieceInTheWay == false){
            //System.out.println("Third file " + ChessBoard.startingFile + "");
            //System.out.println("Third rank " + ChessBoard.startingRank + "");
            return ChessBoard.changeInRank == ChessBoard.NO_CHANGE_IN_RANK || 
            ChessBoard.changeInFile == ChessBoard.NO_CHANGE_IN_FILE;
        }else{
            //System.out.println("Third " + ChessBoard.startingFile + "");
            //System.out.println("Third " + ChessBoard.startingRank + "");

            return false;
        }
    }
}
