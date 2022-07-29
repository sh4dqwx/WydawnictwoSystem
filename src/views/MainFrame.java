package views;

import javax.swing.JFrame;
import views.panels.*;

public class MainFrame extends JFrame {
    private PagesPanel pagesPanel;

    public MainFrame(MainPanel mainPanel, AuthorsPanel authorsPanel) {
        super();
        setTitle("Wydawnictwo ePress");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        pagesPanel = new PagesPanel(mainPanel, authorsPanel);
        add(pagesPanel);
    }
}
