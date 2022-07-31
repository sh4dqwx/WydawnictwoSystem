package models;

import java.util.ArrayList;
import models.contracts.Contract;

public class ProgramDept {
    private ArrayList<Author> authorsList;
    private ArrayList<Contract> contractsList;

    public ProgramDept(ArrayList<Author> authorsList, ArrayList<Contract> contractsList) {
        this.authorsList = authorsList;
        this.contractsList = contractsList;
    }

    //Autorzy
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

    //Umowy
    public Contract[] getContractsList() {
        Contract[] toSend = new Contract[contractsList.size()];
        System.arraycopy(contractsList.toArray(), 0, toSend, 0, toSend.length);
        return toSend;
    }
}
