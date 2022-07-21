package views.panels;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JButton;

public class MainPanel extends JPanel {
    private BufferedImage background;
    private JButton saveButton, loadButton;

    public MainPanel() {
        super();
        try {
            background = ImageIO.read(new File("spider-writer.jpg"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Wydawnictwo ePress");
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 80));
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(JLabel.CENTER);

        JPanel buttons = new JPanel(new FlowLayout());
        saveButton = new JButton("Zapisz do pliku");
        buttons.add(saveButton);
        loadButton = new JButton("Wczytaj z pliku");
        buttons.add(loadButton);

        add(title, BorderLayout.NORTH);
        add(buttons, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);            
    }
}