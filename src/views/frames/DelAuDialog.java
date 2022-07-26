package views.frames;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Frame;

public class DelAuDialog extends JDialog {
    public DelAuDialog(Frame owner, String title) {
        super(owner, title);
        setModal(true);
        add(new JLabel("Jazda jazda"));
        pack();
    }
}
