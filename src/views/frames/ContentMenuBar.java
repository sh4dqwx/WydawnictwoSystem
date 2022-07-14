package views.frames;
import javax.swing.JButton;
import javax.swing.JMenuBar;

public class ContentMenuBar extends JMenuBar {
    private JButton mainPanelButton, authorsButton;
    
    public ContentMenuBar() {
        mainPanelButton = new JButton("Strona główna");
        authorsButton = new JButton("Autorzy");

        add(mainPanelButton);
        add(authorsButton);
    }
}
