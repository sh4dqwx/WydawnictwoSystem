import views.MainFrame;
import views.panels.*;
import models.*;
import controllers.*;
public class App {
    public static void main(String[] args) throws Exception {
        MainPanel mainPanel = new MainPanel();
        AuthorsPanel authorsPanel = new AuthorsPanel();
        ContractsPanel contractsPanel = new ContractsPanel();
        WorksPanel worksPanel = new WorksPanel();
        ShopPanel shopPanel = new ShopPanel();
        MainFrame mainFrame = new MainFrame(mainPanel, authorsPanel, contractsPanel, worksPanel, shopPanel);
        Publisher publisher = new Publisher();
        new SaveLoadController(mainFrame, publisher, mainPanel);
        new AuthorsController(mainFrame, publisher, authorsPanel);
        new ContractsController(mainFrame, publisher, authorsPanel, contractsPanel, worksPanel);
        new WorksController(mainFrame, publisher, worksPanel);
        new ShopController(mainFrame, publisher, shopPanel);
        mainFrame.setVisible(true);
    }
}
