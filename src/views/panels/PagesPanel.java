package views.panels;

import javax.swing.JTabbedPane;

public class PagesPanel extends JTabbedPane {
    private MainPanel mainPanel;
    private AuthorsPanel authorsPanel;

    public PagesPanel() {
        super();
        mainPanel = new MainPanel();
        authorsPanel = new AuthorsPanel();
        addTab("Strona główna", mainPanel);
        addTab("Autorzy", authorsPanel);
    }
}
