package controllers;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import views.MainFrame;
import views.panels.ContractsPanel;
import models.Publisher;

public class ContractsController extends Controller {
    private ContractsPanel contractsPanel;

    public ContractsController(MainFrame mainFrame, Publisher publisher, ContractsPanel contractsPanel) {
        super(mainFrame, publisher);
        this.contractsPanel = contractsPanel;
        contractsPanel.addListeners(new ShowMakeConDListener(), new ShowTermConDListener());
    }

    public class ShowMakeConDListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }
    public class ShowTermConDListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
        }
    }
}
