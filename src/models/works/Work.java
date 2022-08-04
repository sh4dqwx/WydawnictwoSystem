package models.works;

import models.Author;

public class Work {
    private String title;
    private Author author;
    private int copyAm;
    private double price;

    public Work(String title, Author author, int copyAm, double price) {
        this.title = title;
        this.author = author;
        this.copyAm = copyAm;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return '\"' + title + "\" - " + author.toString();
    }
    public String toShop() {
        return toString() + ", " + price + "zł/szt " + copyAm + "szt.";
    }
    public String toSave() {
        return title + ',' + author.toSave() + ',' + copyAm + ',' + price;
    }
}
