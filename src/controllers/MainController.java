package controllers;

import views.frames.*;
import models.*;

public class MainController {
    private MainFrame mainFrame;
    private Publisher publisher;

    public MainController(MainFrame mainFrame, Publisher publisher) {
        this.mainFrame = mainFrame;
        this.publisher = publisher;
    }
}
