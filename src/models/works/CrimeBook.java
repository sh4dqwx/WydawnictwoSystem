package models.works;

import models.Author;

public class CrimeBook extends Book {
    public CrimeBook(String title, Author author, int copyAm, double price) {
        super(title, author, copyAm, price);
    }

    public String toSave() {
        return "kryminał," + super.toSave();
    }
}
