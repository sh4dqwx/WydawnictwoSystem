package models.works;

import models.Author;

public class Album extends Book {
    public Album(String title, Author author, int copyAm, double price) {
        super(title, author, copyAm, price);
    }

    public String toSave() {
        return "album," + super.toSave();
    }
}
