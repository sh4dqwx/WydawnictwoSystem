package views.dialogs;

import javax.swing.JDialog;
import java.awt.Frame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;

public class MakeConDialog extends JDialog {
    public MakeConDialog(Frame owner, String title) {
        super(owner, title);
        setModal(true);
        setResizable(false);

        JLabel text = new JLabel("Siema");
        add(text);
        pack();
    }

    public void addListener(ActionListener makeConListener) {

    }
}
