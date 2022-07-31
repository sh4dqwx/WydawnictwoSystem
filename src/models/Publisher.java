package models;

import java.util.ArrayList;
import models.contracts.Contract;
import models.works.Work;

public class Publisher {
    private ArrayList<Author> authorsList;
    private ArrayList<Contract> contractsList;
    private ArrayList<Work> worksList;
    private ProgramDept programDept;
    private PrintDept printDept;
    private TradeDept tradeDept;

    public Publisher() {
        authorsList = new ArrayList<Author>();
        contractsList = new ArrayList<Contract>();
        worksList = new ArrayList<Work>();
        programDept = new ProgramDept(authorsList, contractsList);
        printDept = new PrintDept(worksList);
        tradeDept = new TradeDept(worksList);
    }

    //Autorzy
    public void addAuthor(Author author) {
        programDept.addAuthor(author);
    }
    public void deleteAuthor(Author author) {
        programDept.deleteAuthor(author);
    }
    public Author[] getAuthorsList() {
        return programDept.getAuthorsList();
    }

    //Umowy
    public Contract[] getContractsList() {
        return programDept.getContractsList();
    }

    //Prace
    public Work[] getWorksList() {
        return printDept.getWorksList();
    }

    //Sklep
    public String[] getShopList() {
        return tradeDept.getShopList();
    }

    //Ogólne:

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
