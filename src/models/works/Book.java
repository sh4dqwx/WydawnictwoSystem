package models.works;

import models.Author;

public class Book extends Work {
    public Book(String title, Author author, int copyAm, double price) {
        super(title, author, copyAm, price);
    }

    public String toSave() {
        return super.toSave();
    }
}
