package models;

import java.util.ArrayList;

public class ProgramDept {
    private ArrayList<Author> authorsList;

    public ProgramDept(ArrayList<Author> authorsList) {
        this.authorsList = authorsList;
    }

    public void addAuthor(Author author) {

    }
    public void deleteAuthor(Author author) {

    }
    public Author[] getAuthorsList() {
        return (Author[])authorsList.toArray();
    }
}
