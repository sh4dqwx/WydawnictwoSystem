package models.works;

import models.Author;

public class Magazine extends Work {
    public Magazine(String title, Author author, int copyAm, double price) {
        super(title, author, copyAm, price);
    }

    public String toSave() {
        return super.toSave();
    }
}
