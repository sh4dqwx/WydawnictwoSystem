package views.panels;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import javax.swing.JPanel;
import views.frames.MainFrame;

public class MainPanel extends JPanel {
    private MainFrame mainFrame;
    private BufferedImage background;
    private JLabel bigTitle;

    public MainPanel() {
        setLayout(new BorderLayout());

        try {
            background = ImageIO.read(new File("spider-writer.jpg"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        bigTitle = new JLabel("Wydawnictwo ePress");
        bigTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 80));
        bigTitle.setForeground(Color.WHITE);
        bigTitle.setHorizontalAlignment(JLabel.CENTER);
        add(bigTitle, BorderLayout.NORTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);            
    }
}