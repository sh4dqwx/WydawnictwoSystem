package views.frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import views.panels.AuthorsPanel;
import views.panels.MainPanel;

public class MainFrame extends JFrame {
    private ContentMenuBar contentMenuBar;
    private MainPanel mainPanel;
    private AuthorsPanel authorsPanel;
    private JPanel currentPanel;

    public MainFrame(MainPanel mainPanel, AuthorsPanel authorsPanel) {
        setTitle("Wydawnictwo ePress");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        contentMenuBar = new ContentMenuBar();
        this.mainPanel = mainPanel;
        this.authorsPanel = authorsPanel;
        currentPanel = this.mainPanel;

        setJMenuBar(contentMenuBar);
        add(currentPanel);
    }

    public void showPanel(JPanel selectedPanel) {
        if(currentPanel == selectedPanel) return;
        remove(currentPanel);
        currentPanel = selectedPanel;
        add(currentPanel);
    }
    public void removeCurrentPanel() {
        remove(mainPanel);
    }

    public void addMainPanelListener(ActionListener mainPanelListener) {
        contentMenuBar.addMainPanelListener(mainPanelListener);
    }

    public void addAuthorsPanelListener(ActionListener authorsPanelListener) {
        contentMenuBar.addAuthorsPanelListener(authorsPanelListener);
    }
}
