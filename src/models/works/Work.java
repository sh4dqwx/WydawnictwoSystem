package models.works;

import models.Author;

public class Work {
    private String title;
    private Author author;
    private int copyAm;
    private double price;

    public Work(String title, Author author, double price) {
        this.title = title;
        this.author = author;
        copyAm = 0;
        this.price = price;
    }

    @Override
    public String toString() {
        return '\"' + title + "\" - " + author.toString();
    }

    public String toShop() {
        return toString() + ", " + price + "zł/szt " + copyAm + "szt.";
    }
}
