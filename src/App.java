import views.frames.*;
import models.*;
import controllers.*;
public class App {
    public static void main(String[] args) throws Exception {
        MainFrame mainFrame = new MainFrame();
        Publisher publisher = new Publisher();
        new MainController(mainFrame, publisher);
        mainFrame.setVisible(true);
    }
}
