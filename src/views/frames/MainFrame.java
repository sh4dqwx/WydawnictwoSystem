package views.frames;
import java.awt.Color;
import javax.swing.JFrame;
import views.panels.AuthorsPanel;
import views.panels.MainPanel;

public class MainFrame extends JFrame {
    private ContentMenuBar contentMenuBar;
    private MainPanel mainPanel;
    private AuthorsPanel authorsPanel;

    public MainFrame() {
        setTitle("Wydawnictwo ePress");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentMenuBar = new ContentMenuBar();
        mainPanel = new MainPanel();
        authorsPanel = new AuthorsPanel();

        setJMenuBar(contentMenuBar);
        add(mainPanel);
        setVisible(true);
    }
}
