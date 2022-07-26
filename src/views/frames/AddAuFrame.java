package views.frames;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.Frame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import models.Author;
import exceptions.EmptyDataException;

public class AddAuFrame extends JDialog {
    private JTextField name, surname;
    private JSpinner age;
    private JButton submit;

    public AddAuFrame(Frame owner, String title) {
        super(owner, title);
        setModal(true);

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
        age = new JSpinner(new SpinnerNumberModel(18, 18, 99, 1));
        ageP.add(age);

        dataP.add(nameP);
        dataP.add(surnameP);
        dataP.add(ageP);

        JPanel buttonsP = new JPanel();
        submit = new JButton("Dodaj autora");
        buttonsP.add(submit);

        add(titleP, BorderLayout.NORTH);
        add(dataP, BorderLayout.CENTER);
        add(buttonsP, BorderLayout.SOUTH);
        pack();
    }

    public void addListener(ActionListener addAuthorListener) {
        submit.addActionListener(addAuthorListener);
    }

    public Author getAuthor() throws EmptyDataException {
        if(name.getText().length() == 0 || surname.getText().length() == 0) throw new EmptyDataException("Podaj dane autora");
        return new Author(name.getText(), surname.getText(), (int)age.getValue());
    }

    public void refresh() {
        name.setText("");
        surname.setText("");
        age.setValue(18);
    }
}
