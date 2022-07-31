package controllers;

import views.MainFrame;
import views.panels.ShopPanel;
import models.Publisher;

public class ShopController extends Controller {
    private ShopPanel shopPanel;

    public ShopController(MainFrame mainFrame, Publisher publisher, ShopPanel shopPanel) {
        super(mainFrame, publisher);
        this.shopPanel = shopPanel;
    }
}
