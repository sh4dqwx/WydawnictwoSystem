package controllers;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import views.MainFrame;
import views.panels.ContractsPanel;
import views.dialogs.MakeConDialog;
import views.dialogs.TermConDialog;
import models.Publisher;

public class ContractsController extends Controller {
    private ContractsPanel contractsPanel;
    private MakeConDialog makeConDialog;
    private TermConDialog termConDialog;

    public ContractsController(MainFrame mainFrame, Publisher publisher, ContractsPanel contractsPanel) {
        super(mainFrame, publisher);
        this.contractsPanel = contractsPanel;
        contractsPanel.addListeners(new ShowMakeConDListener(), new ShowTermConDListener());
    }

    public class ShowMakeConDListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            makeConDialog = new MakeConDialog(mainFrame, "Zawrzyj umowę", publisher.getAuthorsList());
            makeConDialog.addListener(new MakeConListener());
            makeConDialog.setVisible(true);
        }
    }
    public class MakeConListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            publisher.addContract(makeConDialog.getContract());
            contractsPanel.refresh(publisher.getContractsList());
            makeConDialog.dispose();
        }
    }
    public class ShowTermConDListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            termConDialog = new TermConDialog(mainFrame, "Rozwiąż umowę");
            termConDialog.addListener(new TermConListener());
            termConDialog.setVisible(true);
        }
    }
    public class TermConListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
        }
    }
}
