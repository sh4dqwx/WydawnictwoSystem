package models;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ProgramDept {
    private ArrayList<Author> authorsList;

    public ProgramDept(ArrayList<Author> authorsList) {
        this.authorsList = authorsList;
    }

    public void addAuthor(Author author) {
        authorsList.add(author);
    }
    public void deleteAuthor(Author author) {
        authorsList.remove(author);
    }
    public Author[] getAuthorsList() {
        Author[] toSend = new Author[authorsList.size()];
        System.arraycopy(authorsList.toArray(), 0, toSend, 0, toSend.length);
        return toSend;
    }
}
