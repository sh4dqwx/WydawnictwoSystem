package views.panels;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;
import models.Author;

public class AuthorsPanel extends JPanel {
    private JList<Author> list;
    private BufferedImage bg;
    private JButton addAuB, delAuB;

    public AuthorsPanel() {
        super();
        setLayout(new BorderLayout());
        
        try {
            bg = ImageIO.read(new File("monke-writer.jpg"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        list = new JList<Author>();

        JPanel buttons = new JPanel(new FlowLayout());
        buttons.setOpaque(false);
        addAuB = new JButton("Dodaj autora");
        buttons.add(addAuB);
        delAuB = new JButton("Usuń autora");
        buttons.add(delAuB);

        add(list, BorderLayout.NORTH);
        add(buttons, BorderLayout.SOUTH);
    }

    public void refresh(Author[] authorsList) {
        list.setListData(authorsList);
    }

    public void addListeners(ActionListener showAddAuDListener, ActionListener showDelAuDListener) {
        addAuB.addActionListener(showAddAuDListener);
        delAuB.addActionListener(showDelAuDListener);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, this);            
    }
}
