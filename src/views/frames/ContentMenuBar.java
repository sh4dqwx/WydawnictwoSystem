package views.frames;

import java.awt.event.ActionListener;
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

    public void addMainPanelListener(ActionListener mainPanelListener) {
        mainPanelButton.addActionListener(mainPanelListener);
    }

    public void addAuthorsPanelListener(ActionListener authorsPanelListener) {
        authorsButton.addActionListener(authorsPanelListener);
    }
}
