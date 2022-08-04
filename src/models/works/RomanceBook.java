package models.works;

import models.Author;

public class RomanceBook extends Book {
    public RomanceBook(String title, Author author, int copyAm, double price) {
        super(title, author, copyAm, price);
    }

    public String toSave() {
        return "romans," + super.toSave();
    }
}
