package views.panels;

import javax.swing.JTabbedPane;

public class PagesPanel extends JTabbedPane {
    private MainPanel mainPanel;
    private AuthorsPanel authorsPanel;

    public PagesPanel(MainPanel mainPanel, AuthorsPanel authorsPanel) {
        super();
        this.mainPanel = mainPanel;
        this.authorsPanel = authorsPanel;
        addTab("Strona główna", mainPanel);
        addTab("Autorzy", authorsPanel);
    }
}
