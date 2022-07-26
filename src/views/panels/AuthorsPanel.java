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
    private BufferedImage background;
    private JButton addAuthorButton, deleteAuthorButton;

    public AuthorsPanel() {
        super();
        setLayout(new BorderLayout());
        
        try {
            background = ImageIO.read(new File("monke-writer.jpg"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        list = new JList<Author>();

        JPanel buttons = new JPanel(new FlowLayout());
        buttons.setOpaque(false);
        addAuthorButton = new JButton("Dodaj autora");
        buttons.add(addAuthorButton);
        deleteAuthorButton = new JButton("Usuń autora");
        buttons.add(deleteAuthorButton);

        add(list, BorderLayout.NORTH);
        add(buttons, BorderLayout.SOUTH);
    }

    public void refresh(Author[] authorsList) {
        list.setListData(authorsList);
    }

    public void addListeners(ActionListener addAuthorListener, ActionListener deleteAuthorListener) {
        addAuthorButton.addActionListener(addAuthorListener);
        deleteAuthorButton.addActionListener(deleteAuthorListener);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);            
    }
}
