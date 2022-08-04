package views.dialogs;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import java.awt.Frame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import java.awt.BorderLayout;
import java.time.LocalDate;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import models.Author;
import models.contracts.*;

public class MakeConDialog extends JDialog {
    private boolean isNewAu, isWorkCon;
    private JPanel conDataP, conP, workConP, newAuP;
    private JComboBox<Author> author;
    private Author newAu, selAu;
    private JComboBox<String> type;
    private JTextField name, surname, title;
    private JSpinner period, age;
    private JButton submit;

    private void reset() {
        add(conDataP, BorderLayout.CENTER);
        pack();
    }

    private JPanel createConPanel(Author[] authorsList) {
        JPanel titleP = new JPanel();
        titleP.add(new JLabel("Podaj dane umowy"));

        JPanel authorP = new JPanel();
        authorP.add(new JLabel("Autor:"));
        author = new JComboBox<Author>(authorsList);
        newAu = new Author("Nowy", "Autor", 0);
        author.addItem(newAu);
        selAu = (Author)author.getSelectedItem();
        author.addActionListener(new NewAuListener());
        authorP.add(author);

        JPanel typeP = new JPanel();
        typeP.add(new JLabel("Rodzaj:"));
        String[] types = {"Umowa o pracę", "Umowa o dzieło"};
        type = new JComboBox<String>(types);
        typeP.add(type);

        JPanel periodP = new JPanel();
        periodP.add(new JLabel("Na ile lat:"));
        period = new JSpinner(new SpinnerNumberModel(1, 1, 99, 1));
        periodP.add(period);

        JPanel dataP = new JPanel();
        dataP.add(authorP);
        dataP.add(typeP);
        dataP.add(periodP);

        JPanel conP = new JPanel(new BorderLayout());
        conP.add(titleP, BorderLayout.NORTH);
        conP.add(dataP, BorderLayout.CENTER);

        return conP;
    }

    private JPanel createNewAuConPanel() {
        JPanel titleP = new JPanel();
        titleP.add(new JLabel("Podaj dane autora:"));

        JPanel nameP = new JPanel();
        nameP.add(new JLabel("Imię: "));
        name = new JTextField(10);
        nameP.add(name);

        JPanel surnameP = new JPanel();
        surnameP.add(new JLabel("Nazwisko: "));
        surname = new JTextField(10);
        surnameP.add(surname);

        JPanel ageP = new JPanel();
        ageP.add(new JLabel("Wiek: "));
        age = new JSpinner(new SpinnerNumberModel(18, 18, 99, 1));
        ageP.add(age);

        JPanel dataP = new JPanel();
        dataP.add(nameP);
        dataP.add(surnameP);
        dataP.add(ageP);

        JPanel newAuP = new JPanel(new BorderLayout());
        newAuP.add(titleP, BorderLayout.NORTH);
        newAuP.add(dataP, BorderLayout.CENTER);

        return newAuP;
    }

    public MakeConDialog(Frame owner, String title, Author[] authorsList) {
        super(owner, title);
        setModal(true);
        setResizable(false);
        isNewAu = false;
        isWorkCon = false;

        conDataP = new JPanel();
        conDataP.setLayout(new BoxLayout(conDataP, BoxLayout.PAGE_AXIS));

        conP = createConPanel(authorsList);
        conDataP.add(conP);
        if(selAu == newAu) {
            newAuP = createNewAuConPanel();
            conDataP.add(newAuP);
            isNewAu = true;
        }

        JPanel buttonsP = new JPanel();
        submit = new JButton("Zawrzyj umowę");
        buttonsP.add(submit);

        add(buttonsP, BorderLayout.SOUTH);
        reset();
    }

    public Contract getContract() {
        if(isNewAu) selAu = new Author(name.getText(), surname.getText(), (int)age.getValue());
        if(!isWorkCon) {
            return new EmpContract(selAu, LocalDate.now(), LocalDate.now().plusYears((int)period.getValue()));
        } else {
            return new Contract();
        }
    }

    public void addListener(ActionListener makeConListener) {
        submit.addActionListener(makeConListener);
    }

    public class NewAuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            selAu = (Author)author.getSelectedItem();
            if(!isNewAu && selAu.equals(newAu)) {
                if(newAuP == null) newAuP = createNewAuConPanel();
                conDataP.add(newAuP);
                reset();
                isNewAu = true;
            }
            else if(isNewAu && !selAu.equals(newAu)) {
                conDataP.remove(newAuP);
                reset();
                isNewAu = false;
            }
        }
    }
}
