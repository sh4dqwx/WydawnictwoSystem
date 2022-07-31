package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;
import views.MainFrame;
import views.panels.MainPanel;
import models.Publisher;
import models.Author;

public class SaveLoadController extends Controller {
    public SaveLoadController(MainFrame mainFrame, Publisher publisher, MainPanel mainPanel) {
        super(mainFrame, publisher);
        mainPanel.addListeners(new SaveListener(), new LoadListener());
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
        mainFrame.refresh(publisher.getAuthorsList(), publisher.getContractsList(), publisher.getWorksList(), publisher.getShopList());
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
}
