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
    public Author getAuthor(String name, String surname, int age) {
        for(Author au : authorsList) {
            if(name.equals(au.getName()) && surname.equals(au.getSurname()) && age == au.getAge()) {
                return au;
            }
        }
        return null;
    }
    public Author[] getAuthorsList() {
        Author[] toSend = new Author[authorsList.size()];
        System.arraycopy(authorsList.toArray(), 0, toSend, 0, toSend.length);
        return toSend;
    }

    //Umowy
    public void addContract(Contract contract) {
        contractsList.add(contract);
    }
    public void deleteContract(Contract contract) {
        contractsList.remove(contract);
    }
    public Contract[] getContractsList() {
        Contract[] toSend = new Contract[contractsList.size()];
        System.arraycopy(contractsList.toArray(), 0, toSend, 0, toSend.length);
        return toSend;
    }
}
