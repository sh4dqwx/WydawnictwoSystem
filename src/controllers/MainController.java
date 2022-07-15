package controllers;

import views.frames.*;
import views.panels.*;
import models.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

        mainFrame.addMainPanelListener(new MainPanelListener());
        mainFrame.addAuthorsPanelListener(new AuthorsPanelListener());
    }

    public class MainPanelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainFrame.showPanel(mainPanel);
        }
    }

    public class AuthorsPanelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainFrame.removeCurrentPanel();
            System.out.println("dopa");
        }
    }
}
