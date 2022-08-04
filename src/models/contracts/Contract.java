package models.contracts;

import models.Author;

public class Contract {
    protected Author author;

    public Contract() {
        author = null;
    }
    public Contract(Author author) {
        this.author = author;
    }

    public String toSave() {
        return "";
    }
}
