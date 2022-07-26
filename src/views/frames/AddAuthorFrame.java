package views.frames;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;

public class AddAuthorFrame extends JFrame {
    private JTextField name, surname, age;

    public AddAuthorFrame() {
        JPanel titleP = new JPanel();
        titleP.add(new JLabel("Podaj dane autora:"));

        JPanel dataP = new JPanel();

        JPanel nameP = new JPanel(new FlowLayout());
        nameP.add(new JLabel("Imię: "));
        name = new JTextField(10);
        nameP.add(name);

        JPanel surnameP = new JPanel(new FlowLayout());
        surnameP.add(new JLabel("Nazwisko: "));
        surname = new JTextField(10);
        surnameP.add(surname);

        JPanel ageP = new JPanel(new FlowLayout());
        ageP.add(new JLabel("Wiek: "));
        age = new JTextField(10);
        ageP.add(age);

        dataP.add(nameP);
        dataP.add(surnameP);
        dataP.add(ageP);

        JPanel buttonsP = new JPanel();
        buttonsP.add(new JButton("Dodaj autora"));

        add(titleP, BorderLayout.NORTH);
        add(dataP, BorderLayout.CENTER);
        add(buttonsP, BorderLayout.SOUTH);
        pack();
    }
}
