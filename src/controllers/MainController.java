package controllers;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import views.frames.*;
import views.panels.*;
import models.*;
import exceptions.EmptyDataException;

public class MainController {
    private MainFrame mainFrame;
    private MainPanel mainPanel;
    private AuthorsPanel authorsPanel;
    private AddAuFrame addAuFrame;
    private DelAuFrame delAuFrame;
    private Publisher publisher;

    public MainController(MainFrame mainFrame, MainPanel mainPanel, AuthorsPanel authorsPanel, Publisher publisher) {
        this.mainFrame = mainFrame;
        this.mainPanel = mainPanel;
        this.authorsPanel = authorsPanel;
        this.publisher = publisher;

        authorsPanel.addListeners(new ShowAddAuFListener(), new ShowDelAuFListener());
    }

    public class ShowAddAuFListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            addAuFrame = new AddAuFrame(mainFrame, "Dodaj autora");
            addAuFrame.addListener(new AddAuthorListener());
            addAuFrame.setVisible(true);
        }
    }
    public class AddAuthorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                publisher.addAuthor(addAuFrame.getAuthor());
            }
            catch(EmptyDataException ex) {
                JOptionPane.showMessageDialog(addAuFrame, ex.getMessage(), "UWAGA", JOptionPane.WARNING_MESSAGE);
                addAuFrame.refresh();
                return;
            }
            authorsPanel.refresh(publisher.getAuthorsList()); 
            addAuFrame.dispose();
        }
    }
    public class ShowDelAuFListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //delAuFrame = new DelAuFrame(mainFrame, "uwaga");
            //delAuFrame.setVisible(true);
            publisher.deleteAuthor(new Author());
            authorsPanel.refresh(publisher.getAuthorsList());            
        }
    }
}
