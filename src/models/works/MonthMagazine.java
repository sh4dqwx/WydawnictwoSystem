package models.works;

import models.Author;

public class MonthMagazine extends Magazine {
    public MonthMagazine(String title, Author author, int copyAm, double price) {
        super(title, author, copyAm, price);
    }

    public String toSave() {
        return "miesięcznik," + super.toSave();
    }
}
