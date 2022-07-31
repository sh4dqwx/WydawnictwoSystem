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
        mainFrame.setVisible(true);
    }
}
