package models;

public class Author {
    private String name, surname;
    private int age;

    public Author() {
        name = "test";
        surname = "test";
        age = 20;
    }
    public Author(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}
