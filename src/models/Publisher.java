package models;
import java.util.ArrayList;
public class Publisher {
    private ArrayList<Author> authorsList;
    private ProgramDept programDept;
    private PrintDept printDept;
    private TradeDept tradeDept;

    public Publisher() {
        authorsList = new ArrayList<Author>();
        programDept = new ProgramDept(authorsList);
        printDept = new PrintDept();
        tradeDept = new TradeDept();
    }

    public void addAuthor(Author author) {
        programDept.addAuthor(author);
    }
    public void deleteAuthor(Author author) {
        programDept.deleteAuthor(author);
    }
    public Author[] getAuthorsList() {
        return programDept.getAuthorsList();
    }

    public void clear() {
        authorsList.clear();
    }

    public String toSave() {
        String toSend = "";

        for(Author au : authorsList) {
            toSend += "A," + au.toSave() + '\n';
        }

        if(toSend.length() > 0) {
            toSend = toSend.substring(0, toSend.length() - 1);
        }
        return toSend;
    }
}
