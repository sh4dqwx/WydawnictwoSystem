package views;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import views.panels.*;
import models.Author;
import models.contracts.Contract;
import models.works.Work;

public class MainFrame extends JFrame {
    private AuthorsPanel authorsPanel;
    private ContractsPanel contractsPanel;
    private WorksPanel worksPanel;
    private ShopPanel shopPanel;

    public MainFrame(MainPanel mainPanel, AuthorsPanel authorsPanel, ContractsPanel contractsPanel, WorksPanel worksPanel, ShopPanel shopPanel) {
        super();
        setTitle("Wydawnictwo ePress");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JTabbedPane pagesPane = new JTabbedPane();
        pagesPane.addTab("Strona główna", mainPanel);
        pagesPane.addTab("Autorzy", authorsPanel);
        pagesPane.addTab("Umowy", contractsPanel);
        pagesPane.addTab("Prace", worksPanel);
        pagesPane.addTab("Sklep", shopPanel);
        add(pagesPane);
    }

    public void refresh(Author[] authorsList, Contract[] contractsList, Work[] worksList, String[] shopList) {
        authorsPanel.refresh(authorsList);
        contractsPanel.refresh(contractsList);
        worksPanel.refresh(worksList);
        shopPanel.refresh(shopList);
    }
}
