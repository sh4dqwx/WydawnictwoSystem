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
    private JComboBox<Author> author;
    private Author newAu;
    private JComboBox<String> type;
    private JTextField name, surname;
    private JSpinner period, age;
    private JButton submit;

    private void addConPanel(JPanel dataP, Author[] authorsList) {
        JPanel titleP = new JPanel();
        titleP.add(new JLabel("Podaj dane umowy"));

        JPanel authorP = new JPanel();
        authorP.add(new JLabel("Autor:"));
        author = new JComboBox<Author>(authorsList);
        newAu = new Author("Nowy", "Autor", 0);
        author.addItem(newAu);
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

        JPanel conDataP = new JPanel();
        conDataP.add(authorP);
        conDataP.add(typeP);
        conDataP.add(periodP);

        JPanel conP = new JPanel();
        conP.setLayout(new BoxLayout(conP, BoxLayout.PAGE_AXIS));
        conP.add(titleP);
        conP.add(conDataP);

        dataP.add(conP);
    }

    public MakeConDialog(Frame owner, String title, Author[] authorsList) {
        super(owner, title);
        setModal(true);
        setResizable(false);
        isNewAu = false;
        isWorkCon = false;

        JPanel dataP = new JPanel();
        dataP.setLayout(new BoxLayout(dataP, BoxLayout.PAGE_AXIS));
        addConPanel(dataP, authorsList);
        author.addActionListener(new NewAuListener());

        JPanel buttonsP = new JPanel();
        submit = new JButton("Zawrzyj umowę");
        buttonsP.add(submit);

        add(dataP, BorderLayout.CENTER);
        add(buttonsP, BorderLayout.SOUTH);
        pack();
    }

    public Contract getContract() {
        String selType = (String)type.getSelectedItem();
        if(selType.equals("Umowa o pracę")) {
            return new EmpContract((Author)author.getSelectedItem(), LocalDate.now(), LocalDate.now().plusYears((int)period.getValue()));
        } else {
            return new Contract();
        }
    }

    public void addListener(ActionListener makeConListener) {
        submit.addActionListener(makeConListener);
    }

    public class NewAuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Author selAu = (Author)author.getSelectedItem();
            if(selAu.equals(newAu) && isNewAu == false) {
                System.out.println("dupa");
                isNewAu = true;
            }
        }
    }
}
