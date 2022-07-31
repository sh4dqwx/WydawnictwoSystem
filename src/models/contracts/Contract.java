package models.contracts;

import java.time.LocalDate;
import models.Author;

public class Contract {
    protected Author author;
    protected LocalDate startDate, endDate;

    public Contract(Author author, LocalDate startDate, LocalDate endDate) {
        this.author = author;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
