package views.dialogs;

import javax.swing.JDialog;
import java.awt.Frame;
import java.awt.event.ActionListener;

public class TermConDialog extends JDialog {
    public TermConDialog(Frame owner, String title) {
        super(owner, title);
    }

    public void addListener(ActionListener makeConListener) {

    }
}
