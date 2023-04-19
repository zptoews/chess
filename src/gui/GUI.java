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
    int x = 0;
    int y = 0;
    //int imageX1 = imageX + 225;
    //int imageY1 = imageY + 225;
    int fsx = 200;
    int fsy = 125;

    public GUI(ChessBoard chessBoard) {

        setTitle("Chess");

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                exitForm(evt);
            }
        });

        System.out.println("hello world");

        this.getContentPane().setPreferredSize(new Dimension(1500, 800));
        //this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(1500, 800));
        myCanvas = new Canvas();
        panel.add(myCanvas);

        addMouseListener(this);

        this.pack();
        this.toFront();
        this.setVisible(true);

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
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
        g2.drawString("a",fsx - 35,fsy + 560);
        image.paintIcon(this, g, x, y);

    }

    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        System.out.println("Clicked at " + mouseX + ", " + mouseY);
    }

    private void exitForm(WindowEvent evt) {
        System.exit(0);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("press");
    }
}
