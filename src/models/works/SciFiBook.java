package models.works;

import models.Author;

public class SciFiBook extends Book {
    public SciFiBook(String title, Author author, int copyAm, double price) {
        super(title, author, copyAm, price);
    }

    public String toSave() {
        return "scifi," + super.toSave();
    }
}
