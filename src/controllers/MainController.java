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
    private DelAuDialog delAuDialog;
    private Publisher publisher;

    public MainController(MainFrame mainFrame, MainPanel mainPanel, AuthorsPanel authorsPanel, Publisher publisher) {
        this.mainFrame = mainFrame;
        this.mainPanel = mainPanel;
        this.authorsPanel = authorsPanel;
        this.publisher = publisher;

        authorsPanel.addListeners(new ShowAddAuDListener(), new ShowDelAuDListener());
    }

    public class ShowAddAuDListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            addAuDialog = new AddAuDialog(mainFrame, "Dodaj autora");
            addAuDialog.addListener(new AddAuListener());
            addAuDialog.setVisible(true);
        }
    }
    public class AddAuListener implements ActionListener {
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
    public class ShowDelAuDListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(publisher.getAuthorsList().length == 0) {
                JOptionPane.showMessageDialog(mainFrame, "Brak autorów do usunięcia", "UWAGA", JOptionPane.WARNING_MESSAGE);
                return;
            }

            delAuDialog = new DelAuDialog(mainFrame, "Usuń autora", publisher.getAuthorsList());
            delAuDialog.addListener(new DelAuListener());
            delAuDialog.setVisible(true);           
        }
    }
    public class DelAuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            publisher.deleteAuthor(delAuDialog.getAuthor());
            authorsPanel.refresh(publisher.getAuthorsList()); 
            delAuDialog.dispose();
        }
    }
}
