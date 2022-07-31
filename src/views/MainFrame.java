package views;

import javax.swing.JFrame;
import views.panels.*;
import models.Author;
import models.contracts.Contract;
import models.works.Work;

public class MainFrame extends JFrame {
    private PagesPanel pagesPanel;

    public MainFrame(MainPanel mainPanel, AuthorsPanel authorsPanel, ContractsPanel contractsPanel, WorksPanel worksPanel, ShopPanel shopPanel) {
        super();
        setTitle("Wydawnictwo ePress");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        pagesPanel = new PagesPanel(mainPanel, authorsPanel, contractsPanel, worksPanel, shopPanel);
        add(pagesPanel);
    }

    public void refresh(Author[] authorsList, Contract[] contractsList, Work[] worksList, String[] shopList) {
        pagesPanel.refresh(authorsList, contractsList, worksList, shopList);
    }
}
