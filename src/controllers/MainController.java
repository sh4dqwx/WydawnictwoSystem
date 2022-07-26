package controllers;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import views.frames.*;
import views.panels.*;
import models.*;
import exceptions.EmptyDataException;
import exceptions.WrongDataException;

public class MainController {
    private MainFrame mainFrame;
    private MainPanel mainPanel;
    private AuthorsPanel authorsPanel;
    private AddAuDialog addAuDialog;
    private DelAuDialog delAuFrame;
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
            addAuDialog = new AddAuDialog(mainFrame, "Dodaj autora");
            addAuDialog.addListener(new AddAuthorListener());
            addAuDialog.setVisible(true);
        }
    }
    public class AddAuthorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                publisher.addAuthor(addAuDialog.getAuthor());
            }
            catch(Exception ex) {
                JOptionPane.showMessageDialog(addAuDialog, ex.getMessage(), "UWAGA", JOptionPane.WARNING_MESSAGE);
                addAuDialog.refresh();
                return;
            }

            authorsPanel.refresh(publisher.getAuthorsList()); 
            addAuDialog.dispose();
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
