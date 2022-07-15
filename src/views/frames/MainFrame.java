package views.frames;
import javax.swing.JFrame;
import javax.swing.JPanel;
import views.panels.AuthorsPanel;
import views.panels.MainPanel;

public class MainFrame extends JFrame {
    private ContentMenuBar contentMenuBar;
    private MainPanel mainPanel;
    private AuthorsPanel authorsPanel;
    private JPanel currentPanel;

    public MainFrame() {
        setTitle("Wydawnictwo ePress");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        contentMenuBar = new ContentMenuBar();
        mainPanel = new MainPanel(this);
        authorsPanel = new AuthorsPanel();
        currentPanel = mainPanel;

        setJMenuBar(contentMenuBar);
        add(currentPanel);
        setVisible(true);
    }
}
