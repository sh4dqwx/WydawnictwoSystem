package controllers;

import models.Publisher;
import views.MainFrame;

public class Controller {
    protected MainFrame mainFrame;
    protected Publisher publisher;

    public Controller(MainFrame mainFrame, Publisher publisher) {
        this.mainFrame = mainFrame;
        this.publisher = publisher;
    }
}
