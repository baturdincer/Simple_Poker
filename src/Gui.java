import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Gui extends JFrame {
    Game game;
    JPanel panel;

    Gui(){
        game= new Game();
        panel=new JPanel();
        panel.setPreferredSize(new Dimension(1400,750));
        add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        pack();



    }

    public void paint(Graphics g){
        Graphics2D g2d=(Graphics2D) g;
        g2d.setColor(new Color(0x3ED264));
        g2d.fillRect(0,0,1500,900);
        g2d.setFont(new Font("Ink Free",Font.BOLD,50));
        g2d.setColor(Color.YELLOW);
        g2d.drawString(game.wincheck(),500,180);
        g2d.drawImage(game.player1hand.getCard(0).getIcon(),120,300,150,208,null);
        g2d.drawImage(game.player1hand.getCard(1).getIcon(),160,340,150,208,null);
        g2d.drawImage(game.krupiye.getCard(0).getIcon(),450,300,150,208,null);
        g2d.drawImage(game.krupiye.getCard(1).getIcon(),620,300,150,208,null);
        g2d.drawImage(game.krupiye.getCard(2).getIcon(),790,300,150,208,null);
        g2d.drawImage(game.player2hand.getCard(0).getIcon(),1080,300,150,208,null);
        g2d.drawImage(game.player2hand.getCard(1).getIcon(),1120,340,150,208,null);
    }
}
