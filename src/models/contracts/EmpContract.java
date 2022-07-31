package models.contracts;

import java.time.LocalDate;
import models.Author;
import models.works.Work;

public class EmpContract extends Contract {
    private Work currentWork;

    public EmpContract(Author author, LocalDate startDate, LocalDate endDate) {
        super(author, startDate, endDate);
        currentWork = null;
    }

    @Override
    public String toString() {
        return "Umowa o pracę - " + author.toString() + " - od " + startDate.toString() + " do " + endDate.toString();
    }
}
