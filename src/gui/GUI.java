package gui;

/**
 *
 * @author Zachary Toews
 *
 * This class is for actually showing the player(s) what is happening in the
 * game as well as showing previous moves.
 *
 */
import game.ChessBoard;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements MouseListener {

    Canvas myCanvas;
    final String fileName = "resources/game/prawn.png";
    ImageIcon image = new ImageIcon(fileName);
    int ix = 0;
    int iy = 0;
    int fsx = 200;
    int fsy = 125;

    public GUI(ChessBoard chessBoard) {

        setTitle("Chess");

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                exitForm(evt);
            }
        });

        Container content = getContentPane();
        content.setLayout(new GridLayout(8, 8));

        System.out.println("hello world");

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square square = new Square(j,i,chessBoard.getPiece(i,j));
                square.setPreferredSize(new Dimension(70, 70));
                square.setBackground((i + j) % 2 == 0 ? Color.WHITE : Color.BLACK);
                content.add(square);               
            }
        }

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        addMouseListener(this);

        this.pack();
        this.toFront();
        this.setVisible(true);

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        /*
        g2.fillRect(fsx, fsy, 70, 70);
        g2.fillRect(fsx, fsy + 140, 70, 70);
        g2.fillRect(fsx, fsy + 280, 70, 70);
        g2.fillRect(fsx, fsy + 420, 70, 70);
        g2.fillRect(fsx + 70, fsy + 70, 70, 70);
        g2.fillRect(fsx + 70, fsy + 210, 70, 70);
        g2.fillRect(fsx + 70, fsy + 350, 70, 70);
        g2.fillRect(fsx + 70, fsy + 490, 70, 70);
        g2.fillRect(fsx + 140, fsy, 70, 70);
        g2.fillRect(fsx + 140, fsy + 140, 70, 70);
        g2.fillRect(fsx + 140, fsy + 280, 70, 70);
        g2.fillRect(fsx + 140, fsy + 420, 70, 70);
        g2.fillRect(fsx + 210, fsy + 70, 70, 70);
        g2.fillRect(fsx + 210, fsy + 210, 70, 70);
        g2.fillRect(fsx + 210, fsy + 350, 70, 70);
        g2.fillRect(fsx + 210, fsy + 490, 70, 70);
        g2.fillRect(fsx + 280, fsy, 70, 70);
        g2.fillRect(fsx + 280, fsy + 140, 70, 70);
        g2.fillRect(fsx + 280, fsy + 280, 70, 70);
        g2.fillRect(fsx + 280, fsy + 420, 70, 70);
        g2.fillRect(fsx + 350, fsy + 70, 70, 70);
        g2.fillRect(fsx + 350, fsy + 210, 70, 70);
        g2.fillRect(fsx + 350, fsy + 350, 70, 70);
        g2.fillRect(fsx + 350, fsy + 490, 70, 70);
        g2.fillRect(fsx + 420, fsy, 70, 70);
        g2.fillRect(fsx + 420, fsy + 140, 70, 70);
        g2.fillRect(fsx + 420, fsy + 280, 70, 70);
        g2.fillRect(fsx + 420, fsy + 420, 70, 70);
        g2.fillRect(fsx - 70, fsy + 70, 70, 70);
        g2.fillRect(fsx - 70, fsy + 210, 70, 70);
        g2.fillRect(fsx - 70, fsy + 350, 70, 70);
        g2.fillRect(fsx - 70, fsy + 490, 70, 70);
        g2.drawRect(fsx - 70, fsy, 560, 560);
        g2.drawString("A", fsx - 35, fsy + 580);
        g2.drawString("B", fsx + 35, fsy + 580);
        g2.drawString("C", fsx + 105, fsy + 580);
        g2.drawString("D", fsx + 175, fsy + 580);
        g2.drawString("E", fsx + 245, fsy + 580);
        g2.drawString("F", fsx + 315, fsy + 580);
        g2.drawString("G", fsx + 385, fsy + 580);
        g2.drawString("H", fsx + 455, fsy + 580);
        g2.drawString("8", fsx - 105, fsy + 35);
        g2.drawString("7", fsx - 105, fsy + 105);
        g2.drawString("6", fsx - 105, fsy + 175);
        g2.drawString("5", fsx - 105, fsy + 245);
        g2.drawString("4", fsx - 105, fsy + 315);
        g2.drawString("3", fsx - 105, fsy + 385);
        g2.drawString("2", fsx - 105, fsy + 455);
        g2.drawString("1", fsx - 105, fsy + 525);
         */
        image.paintIcon(this, g, ix, iy);

    }

    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        System.out.println("Clicked at " + mouseX + ", " + mouseY);
        /*
        if( mouseX >= fsx - 70 && mouseX <= fsx && mouseY >= fsy && mouseY <= fsy + 560){
        System.out.println("Clicked at A");
        }
        
        if( mouseX >= fsx && mouseX <= fsx + 70 && mouseY >= fsy && mouseY <= fsy + 560){
        System.out.println("Clicked at B");
        }
        
        if( mouseX >= fsx + 70 && mouseX <= fsx + 140 && mouseY >= fsy && mouseY <= fsy + 560){
        System.out.println("Clicked at C");
        }
        
        if( mouseX >= fsx + 140 && mouseX <= fsx + 210 && mouseY >= fsy && mouseY <= fsy + 560){
        System.out.println("Clicked at D");
        }
        
        if( mouseX >= fsx + 210 && mouseX <= fsx + 280 && mouseY >= fsy && mouseY <= fsy + 560){
        System.out.println("Clicked at E");
        }
        
        if( mouseX >= fsx + 280 && mouseX <= fsx + 350 && mouseY >= fsy && mouseY <= fsy + 560){
        System.out.println("Clicked at F");
        }
        
        if( mouseX >= fsx + 350 && mouseX <= fsx + 420 && mouseY >= fsy && mouseY <= fsy + 560){
        System.out.println("Clicked at G");
        }
        
        if( mouseX >= fsx + 420 && mouseX <= fsx + 490 && mouseY >= fsy && mouseY <= fsy + 560){
        System.out.println("Clicked at H");
        }
        
        if( mouseX >= fsx - 70 && mouseX <= fsx + 490 && mouseY >= fsy + 490 && mouseY <= fsy + 560){
        System.out.println("Clicked at 1");
        }
        
        if( mouseX >= fsx - 70 && mouseX <= fsx + 490 && mouseY >= fsy + 420 && mouseY <= fsy + 490){
        System.out.println("Clicked at 2");
        }
        
        if( mouseX >= fsx - 70 && mouseX <= fsx + 490 && mouseY >= fsy + 350 && mouseY <= fsy + 420){
        System.out.println("Clicked at 3");
        }
        
        if( mouseX >= fsx - 70 && mouseX <= fsx + 490 && mouseY >= fsy + 280 && mouseY <= fsy + 350){
        System.out.println("Clicked at 4");
        }
        
        if( mouseX >= fsx - 70 && mouseX <= fsx + 490 && mouseY >= fsy + 210 && mouseY <= fsy + 280){
        System.out.println("Clicked at 5");
        }
        
        if( mouseX >= fsx - 70 && mouseX <= fsx + 490 && mouseY >= fsy + 140 && mouseY <= fsy + 210){
        System.out.println("Clicked at 6");
        }
        
        if( mouseX >= fsx - 70 && mouseX <= fsx + 490 && mouseY >= fsy + 70 && mouseY <= fsy + 140){
        System.out.println("Clicked at 7");
        }
        
        if( mouseX >= fsx - 70 && mouseX <= fsx + 490 && mouseY >= fsy && mouseY <= fsy + 70){
        System.out.println("Clicked at 8");

        }
         */
    }

    private void exitForm(WindowEvent e) {
        System.exit(0);
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }
}
