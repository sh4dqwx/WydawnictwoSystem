package views.panels;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class MainPanel extends JPanel {
    private BufferedImage background;

    public MainPanel() {
        try {
            background = ImageIO.read(new File("spider-writer.jpg")).getScaledInstance(getWidth(), getHeight(), BufferedImage.SCALE_DEFAULT);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);            
    }
}