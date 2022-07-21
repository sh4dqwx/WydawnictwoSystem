import views.frames.*;
import views.panels.*;
import models.*;
import controllers.*;
public class App {
    public static void main(String[] args) throws Exception {
        MainPanel mainPanel = new MainPanel();
        AuthorsPanel authorsPanel = new AuthorsPanel();
        MainFrame mainFrame = new MainFrame(mainPanel, authorsPanel);
        Publisher publisher = new Publisher();
        new MainController(mainFrame, mainPanel, authorsPanel, publisher);
        mainFrame.setVisible(true);
    }
}
