package models.contracts;

import models.Author;
import models.works.Work;

public class WorkContract extends Contract {
    private Work work;

    public WorkContract(Author author, Work work) {
        super(author);
        this.work = work;
    }

    @Override
    public String toString() {
        return "Umowa o dzieło \"" + work.getTitle() + "\" - " + author.toString();
    }
    public String toSave() {
        return "CW," + author.toSave() + ',' + work.getTitle();
    }
}