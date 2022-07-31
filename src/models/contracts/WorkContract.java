package models.contracts;

import java.time.LocalDate;
import models.Author;
import models.works.Work;

public class WorkContract extends Contract {
    private Work work;

    public WorkContract(Author author, LocalDate startDate, LocalDate endDate, Work work) {
        super(author, startDate, endDate);
        this.work = work;
    }

    @Override
    public String toString() {
        return "Umowa o dzieło \"" + work.getTitle() + "\" - " + author.toString() + " - od " + startDate.toString() + " do " + endDate.toString();
    }
}