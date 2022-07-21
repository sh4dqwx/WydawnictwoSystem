package controllers;

import views.frames.*;
import views.panels.*;
import models.*;

public class MainController {
    private MainFrame mainFrame;
    private Publisher publisher;

    public MainController(MainFrame mainFrame, Publisher publisher) {
        this.mainFrame = mainFrame;
        this.publisher = publisher;
    }
}
