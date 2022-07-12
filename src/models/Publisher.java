package models;

public class Publisher {
    private PrintDept printDept;
    private ProgramDept programDept;
    private TradeDept tradeDept;

    public Publisher(PrintDept printDept, ProgramDept programDept, TradeDept tradeDept) {
        this.printDept = printDept;
        this.programDept = programDept;
        this.tradeDept = tradeDept;
    }

    public void addAuthor(Author author) {
        programDept.addAuthor(author);
    }
}
