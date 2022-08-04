package models.works;

import models.Author;

public class HorrorBook extends Book {
    public HorrorBook(String title, Author author, int copyAm, double price) {
        super(title, author, copyAm, price);
    }

    public String toSave() {
        return "horror," + super.toSave();
    }
}
