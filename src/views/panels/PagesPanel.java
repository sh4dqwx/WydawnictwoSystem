package views.panels;

import javax.swing.JTabbedPane;
import models.Author;
import models.contracts.Contract;
import models.works.Work;

public class PagesPanel extends JTabbedPane {
    private AuthorsPanel authorsPanel;
    private ContractsPanel contractsPanel;
    private WorksPanel worksPanel;
    private ShopPanel shopPanel;

    public PagesPanel(MainPanel mainPanel, AuthorsPanel authorsPanel, ContractsPanel contractsPanel, WorksPanel worksPanel, ShopPanel shopPanel) {
        super();
        this.authorsPanel = authorsPanel;
        this.contractsPanel = contractsPanel;
        this.worksPanel = worksPanel;
        this.shopPanel = shopPanel;
        addTab("Strona główna", mainPanel);
        addTab("Autorzy", authorsPanel);
        addTab("Umowy", contractsPanel);
        addTab("Prace", worksPanel);
        addTab("Sklep", shopPanel);
    }

    public void refresh(Author[] authorsList, Contract[] contractsList, Work[] worksList, String[] shopList) {
        authorsPanel.refresh(authorsList);
        contractsPanel.refresh(contractsList);
        worksPanel.refresh(worksList);
        shopPanel.refresh(shopList);
    }
}
