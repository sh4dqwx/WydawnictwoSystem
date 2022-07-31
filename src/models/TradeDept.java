package models;

import java.util.ArrayList;
import models.works.Work;

public class TradeDept {
    private ArrayList<Work> worksList;

    public TradeDept(ArrayList<Work> worksList) {
        this.worksList = worksList;
    }

    //Sklep
    public String[] getShopList() {
        String[] toSend = new String[worksList.size()];
        for(int i=0; i<toSend.length; i++) {
            toSend[i] = worksList.get(i).toShop();
        }
        return toSend;
    }
}
