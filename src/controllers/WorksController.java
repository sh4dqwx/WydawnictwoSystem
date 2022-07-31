package controllers;

import views.MainFrame;
import views.panels.WorksPanel;
import models.Publisher;

public class WorksController extends Controller {
    private WorksPanel worksPanel;

    public WorksController(MainFrame mainFrame, Publisher publisher, WorksPanel worksPanel) {
        super(mainFrame, publisher);
        this.worksPanel = worksPanel;
    }
}
