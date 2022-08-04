package controllers;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import views.MainFrame;
import views.panels.AuthorsPanel;
import views.panels.ContractsPanel;
import views.panels.WorksPanel;
import views.dialogs.MakeConDialog;
import views.dialogs.TermConDialog;
import models.Publisher;

public class ContractsController extends Controller {
    private AuthorsPanel authorsPanel;
    private ContractsPanel contractsPanel;
    private WorksPanel worksPanel;
    private MakeConDialog makeConDialog;
    private TermConDialog termConDialog;

    public ContractsController(MainFrame mainFrame, Publisher publisher, AuthorsPanel authorsPanel, ContractsPanel contractsPanel, WorksPanel worksPanel) {
        super(mainFrame, publisher);
        this.authorsPanel = authorsPanel;
        this.contractsPanel = contractsPanel;
        this.worksPanel = worksPanel;
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
            authorsPanel.refresh(publisher.getAuthorsList());
            contractsPanel.refresh(publisher.getContractsList());
            worksPanel.refresh(publisher.getWorksList());
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
