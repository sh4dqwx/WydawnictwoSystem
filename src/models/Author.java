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

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + ' ' + surname + ' ' + age;
    }
    public String toSave() {
        return name + ',' + surname + ',' + age;
    }
}
