package controllers;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import views.MainFrame;
import views.panels.AuthorsPanel;
import views.dialogs.AddAuDialog;
import views.dialogs.DelAuDialog;
import models.Publisher;

public class AuthorsController extends Controller {
    private AuthorsPanel authorsPanel;
    private AddAuDialog addAuDialog;
    private DelAuDialog delAuDialog;

    public AuthorsController(MainFrame mainFrame, Publisher publisher, AuthorsPanel authorsPanel) {
        super(mainFrame, publisher);
        this.authorsPanel = authorsPanel;
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


