package models;

import java.util.ArrayList;
import models.works.Work;

public class PrintDept {
    private ArrayList<Work> worksList;

    public PrintDept(ArrayList<Work> worksList) {
        this.worksList = worksList;
    }

    //Prace
    public Work[] getWorksList() {
        Work[] toSend = new Work[worksList.size()];
        System.arraycopy(worksList.toArray(), 0, toSend, 0, toSend.length);
        return toSend;
    }
}
