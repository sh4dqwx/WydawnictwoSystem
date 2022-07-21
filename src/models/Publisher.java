package models;
import java.util.ArrayList;
public class Publisher {
    private ArrayList<Author> authorsList;
    private ProgramDept programDept;

    public Publisher() {
        authorsList = new ArrayList<Author>();
        programDept = new ProgramDept(authorsList);
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
}
