package models.works;

import models.Author;

public class FantasyBook extends Book {
    public FantasyBook(String title, Author author, int copyAm, double price) {
        super(title, author, copyAm, price);
    }

    public String toSave() {
        return "fantasy," + super.toSave();
    }
}
