package controllers;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import views.MainFrame;
import views.dialogs.*;
import views.panels.*;
import models.*;

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

        mainPanel.addListeners(new SaveListener(), new LoadListener());
        authorsPanel.addListeners(new ShowAddAuDListener(), new ShowDelAuDListener());
    }

    public String getSavedPath() {
        return System.getProperty("user.dir") + "\\saved";
    }

    public void save(File selectedFile) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(selectedFile);
        printWriter.write(publisher.toSave());
        printWriter.close();
    }

    public void load(File selectedFile) throws FileNotFoundException {
        publisher.clear();
        Scanner scan = new Scanner(selectedFile);
        while(scan.hasNextLine()) {
            String[] dane = scan.nextLine().split(",");
            switch(dane[0]) {
                case "A" -> {
                    publisher.addAuthor(new Author(dane[1], dane[2], Integer.parseInt(dane[3])));
                }
            }
        }
        scan.close();
        authorsPanel.refresh(publisher.getAuthorsList());
    }

    public class SaveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser saveFile = new JFileChooser(getSavedPath());
            saveFile.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
            int response = saveFile.showSaveDialog(mainFrame);

            if(response == JFileChooser.APPROVE_OPTION) {
                try {
                    save(saveFile.getSelectedFile());
                }
                catch(FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(mainFrame, "Nie znaleziono pliku", "UWAGA", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }
    }
    public class LoadListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser loadFile = new JFileChooser(getSavedPath());
            loadFile.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
            int response = loadFile.showOpenDialog(mainFrame);

            if(response == JFileChooser.APPROVE_OPTION) {
                try {
                    load(loadFile.getSelectedFile());
                }
                catch(FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(mainFrame, "Nie znaleziono pliku", "UWAGA", JOptionPane.WARNING_MESSAGE);
                    return;
                }        
            }
        }
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
