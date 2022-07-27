package views.frames;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import models.Author;

public class DelAuDialog extends JDialog {
    private JComboBox<Author> author;
    private JButton submit;

    public DelAuDialog(Frame owner, String title, Author[] authorsList) {
        super(owner, title);
        setModal(true);
        setResizable(false);

        JPanel titleP = new JPanel();
        titleP.add(new JLabel("Wybierz autora:"));

        JPanel chooseAuP = new JPanel(new FlowLayout());
        author = new JComboBox<Author>(authorsList);
        submit = new JButton("OK");
        chooseAuP.add(author);
        chooseAuP.add(submit);

        add(titleP, BorderLayout.NORTH);
        add(chooseAuP, BorderLayout.CENTER);
        pack();
    }

    public void addListener(ActionListener delAuListener) {
        submit.addActionListener(delAuListener);
    }

    public Author getAuthor() {
        return (Author)author.getSelectedItem();
    }
}
