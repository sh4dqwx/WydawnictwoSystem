package models;

import java.util.ArrayList;
import models.contracts.Contract;
import models.works.*;

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
    public Author getAuthor(String name, String surname, int age) {
        return programDept.getAuthor(name, surname, age);
    }
    public Author[] getAuthorsList() {
        return programDept.getAuthorsList();
    }

    //Umowy
    public void addContract(Contract contract) {
        programDept.addContract(contract);
    }
    public void deleteContract(Contract contract) {
        programDept.deleteContract(contract);
    }
    public Contract[] getContractsList() {
        return programDept.getContractsList();
    }

    //Prace
    public Work newWork(String type, String title, Author author, int copyAm, double price) {
        switch(type) {
            case "album" ->  {
                return new Album(title, author, copyAm, price);
            }
            case "kryminał" -> {
                return new CrimeBook(title, author, copyAm, price);
            }
            case "fantasy" -> {
                return new FantasyBook(title, author, copyAm, price);
            }
            case "horror" -> {
                return new HorrorBook(title, author, copyAm, price);
            }
            case "miesięcznik" -> {
                return new MonthMagazine(title, author, copyAm, price);
            }
            case "romans" -> {
                return new RomanceBook(title, author, copyAm, price);
            }
            case "scifi" -> {
                return new SciFiBook(title, author, copyAm, price);
            }
            case "thriller" -> {
                return new ThrillerBook(title, author, copyAm, price);
            }
            case "tygodnik" -> {
                return new WeekMagazine(title, author, copyAm, price);
            }
        }
        return null;
    }
    public void addWork(Work work) {
        printDept.addWork(work);
    }
    public void deleteWork(Work work) {
        printDept.deleteWork(work);
    }
    public Work getWork(String title) {
        return printDept.getWork(title);
    }
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

        for(Author au : authorsList) toSend += "A," + au.toSave() + '\n';
        for(Work w : worksList) toSend += "W," + w.toSave() + '\n';
        for(Contract con : contractsList) toSend += con.toSave() + '\n';

        if(toSend.length() > 0) {
            toSend = toSend.substring(0, toSend.length() - 1);
        }

        return toSend;
    }
}
