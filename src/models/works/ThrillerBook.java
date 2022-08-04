package models.works;

import models.Author;

public class ThrillerBook extends Book {
    public ThrillerBook(String title, Author author, int copyAm, double price) {
        super(title, author, copyAm, price);
    }

    public String toSave() {
        return "thriller" + super.toSave();
    }
}
