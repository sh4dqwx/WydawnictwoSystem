package views.panels;

import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import models.contracts.Contract;

public class ContractsPanel extends JPanel {
    private BufferedImage bg;
    private JList<Contract> list;
    private JButton makeConB, termConB;

    public ContractsPanel() {
        super();
        setLayout(new BorderLayout());

        try {
            bg = ImageIO.read(new File("contract.jpg"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        list = new JList<Contract>();

        JPanel buttons = new JPanel(new FlowLayout());
        buttons.setOpaque(false);
        makeConB = new JButton("Zawrzyj umowę");
        buttons.add(makeConB);
        termConB = new JButton("Rozwiąż umowę");
        buttons.add(termConB);

        add(list, BorderLayout.NORTH);
        add(buttons, BorderLayout.SOUTH);
    }

    public void refresh(Contract[] contractsList) {
        list.setListData(contractsList);
    }

    public void addListeners(ActionListener showMakeConDListener, ActionListener showTermConDListener) {
        makeConB.addActionListener(showMakeConDListener);
        termConB.addActionListener(showTermConDListener);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, this);            
    }
}
