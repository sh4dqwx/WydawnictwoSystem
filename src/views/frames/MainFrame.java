package views.frames;

import javax.swing.JFrame;
import views.panels.PagesPanel;

public class MainFrame extends JFrame {
    private PagesPanel pagesPanel;

    public MainFrame() {
        setTitle("Wydawnictwo ePress");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        pagesPanel = new PagesPanel();
        add(pagesPanel);
    }
}
