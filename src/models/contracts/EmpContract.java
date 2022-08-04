package models.contracts;

import java.time.LocalDate;
import models.Author;
import models.works.Work;

public class EmpContract extends Contract {
    private LocalDate startDate, endDate;
    private Work currentWork;

    public EmpContract(Author author, LocalDate startDate, LocalDate endDate) {
        super(author);
        this.startDate = startDate;
        this.endDate = endDate;
        currentWork = null;
    }
    public EmpContract(Author author, LocalDate startDate, LocalDate endDate, Work currentWork) {
        super(author);
        this.startDate = startDate;
        this.endDate = endDate;
        this.currentWork = currentWork;
    }

    @Override
    public String toString() {
        return "Umowa o pracę - " + author.toString() + " - od " + startDate.toString() + " do " + endDate.toString();
    }
    public String toSave() {
        String toSend = "CE," + author.toSave() + ',' + 
        startDate.getYear() + ',' + startDate.getMonthValue() + ',' + startDate.getDayOfMonth() + ',' +
        endDate.getYear() + ',' + endDate.getMonthValue() + ',' + endDate.getDayOfMonth();
        if(currentWork == null) toSend += ",-";
        else toSend += currentWork.getTitle();
        return toSend;
    }
}
