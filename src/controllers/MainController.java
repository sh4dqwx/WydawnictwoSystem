package controllers;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import views.frames.*;
import views.panels.*;
import models.*;

public class MainController {
    private MainFrame mainFrame;
    private MainPanel mainPanel;
    private AuthorsPanel authorsPanel;
    private Publisher publisher;

    public MainController(MainFrame mainFrame, MainPanel mainPanel, AuthorsPanel authorsPanel, Publisher publisher) {
        this.mainFrame = mainFrame;
        this.mainPanel = mainPanel;
        this.authorsPanel = authorsPanel;
        this.publisher = publisher;

        authorsPanel.addListeners(new AddAuthorListener(), new DeleteAuthorListener());
    }

    public class AddAuthorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            publisher.addAuthor(new Author());
            authorsPanel.refresh(publisher.getAuthorsList());
        }
    }

    public class DeleteAuthorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            publisher.deleteAuthor(new Author());
            authorsPanel.refresh(publisher.getAuthorsList());            
        }
    }
}
