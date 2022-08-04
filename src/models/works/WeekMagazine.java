package models.works;

import models.Author;

public class WeekMagazine extends Magazine {
    public WeekMagazine(String title, Author author, int copyAm, double price) {
        super(title, author, copyAm, price);
    }

    public String toSave() {
        return "tygodnik," + super.toSave();
    }
}
