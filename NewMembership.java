import javax.swing.*;
import java.awt.event.*;
import java.time.*;

public class NewMembership {
    public static void createTextField (JTextField textField, JFrame frame, int y) {
        textField.setBounds(50,y,150,30);  
        frame.add(textField);
    }

    public static void createLabel(JLabel label, JFrame frame, int y) {
        label.setBounds(50, y, 150, 20);
        frame.add(label);
    }

    public static void changeToNewMembership(JFrame oldFrame){
        oldFrame.setVisible(false);
        newMembership();
    }
    
    public static void newMembership() {
        JFrame f = new JFrame("New Membership Creation");
        f.setVisible(true);

        JLabel nameLabel = new JLabel("Name:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel idLabel = new JLabel("Id:");
        JLabel addressLabel = new JLabel("Address:");
        JLabel ssnLabel = new JLabel("SSN: (XXXXXXXXX)");

        JTextField nameInput = new JTextField();
        JTextField emailInput = new JTextField();
        JTextField idInput = new JTextField();
        JTextField addressInput = new JTextField();
        JTextField ssnInput = new JTextField();

        JLabel monthLabel = new JLabel("Birth Month:");
        String months[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        JComboBox<String> monthInput = new JComboBox<>(months);

        JLabel dayLabel = new JLabel("Birth Day:");
        String days[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        JComboBox<String> dayInput = new JComboBox<>(days);

        JLabel yearLabel = new JLabel("Birth Year: (YYYY)");
        JTextField yearInput = new JTextField();

        JLabel typeLabel = new JLabel("Type of Member:");
        String types[] = {"Professor", "Student", "External"};
        JComboBox<String> typeInput = new JComboBox<>(types);

        JButton submit = new JButton("Submit");


        JButton menuButton = new JButton("Menu");
        menuButton.setBounds(0, 0, 75, 20);
        f.add(menuButton);
        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                StartMenu.changeToStartMenu(f);
            }   
        });

        int yLabel = 30;
        int yInput = 50;
        int yInc = 60;

        JLabel labels[] = {nameLabel, emailLabel, idLabel, addressLabel, ssnLabel};
        for (JLabel label : labels) {
            createLabel(label, f, yLabel);
            yLabel += yInc;
        }

        JTextField textFields[] = {nameInput, emailInput, idInput, addressInput, ssnInput};
        for (JTextField textField : textFields) {
            createTextField(textField, f, yInput);
            yInput += yInc;
        }

        monthLabel.setBounds(50, 320, 150, 30);
        f.add(monthLabel);
        monthInput.setBounds(50, 350, 150, 30);
        f.add(monthInput);

        dayLabel.setBounds(50, 380, 150, 30);
        f.add(dayLabel);
        dayInput.setBounds(50, 410, 150, 30);
        f.add(dayInput);

        yearLabel.setBounds(50, 440, 150, 30);
        f.add(yearLabel);
        yearInput.setBounds(50, 470, 150, 30);
        f.add(yearInput);

        typeLabel.setBounds(50, 500, 150, 30);
        f.add(typeLabel);
        typeInput.setBounds(50, 530, 150, 30);
        f.add(typeInput);

        submit.setBounds(50, 590, 150, 30);
        f.add(submit);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    String name = nameInput.getText();
                    String email = emailInput.getText();
                    int id = Integer.parseInt(idInput.getText());
                    if (id < 0)
                        throw new Exception();
                    String address = addressInput.getText();
                    long ssn = Long.parseLong(ssnInput.getText());
                    if (ssn < 0 || ssn > 10000000000L)
                        throw new Exception();
                    int month = Integer.parseInt(monthInput.getItemAt(monthInput.getSelectedIndex()));
                    int day = Integer.parseInt(dayInput.getItemAt(dayInput.getSelectedIndex()));
                    int year = Integer.parseInt(yearInput.getText());
                    if (year < 1900 || year > Year.now().getValue() )
                        throw new Exception();
                    LocalDate dob = LocalDate.of(year, month, day);

                    if (name.isEmpty() || email.isEmpty() || address.isEmpty())
                        throw new Exception();

                    if (typeInput.getItemAt(typeInput.getSelectedIndex()) == "Student") {
                        for (Student student : Main.studentList) {
                            if (student.MemberID == id)
                                throw new Exception();
                        }
                        Student newStudent = new Student(name, dob, email, id, address, ssn);
                        Main.studentList.add(newStudent);
                        System.out.println(Main.studentList);
                    }
                    
                    else if (typeInput.getItemAt(typeInput.getSelectedIndex()) == "Professor") {
                        for (Professor professor : Main.professorList) {
                            if (professor.MemberID == id)
                                throw new Exception();
                        }
                        Professor newProfessor = new Professor(name, dob, email, id, address, ssn);
                        Main.professorList.add(newProfessor);
                        System.out.println(Main.professorList);
                    }
                    
                    else if (typeInput.getItemAt(typeInput.getSelectedIndex()) == "External") {
                        for (External external : Main.externalList) {
                            if (external.MemberID == id)
                                throw new Exception();
                        }
                        External newExternal = new External(name, dob, email, id, address, ssn);
                        Main.externalList.add(newExternal);
                        System.out.println(Main.externalList);
                    }

                    else
                        throw new Exception();
                } catch(Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(f,"Error! One of the items you inputted was not formatted correctly or that id is already in use. Please try again.");
                }
            }
        });


        f.setSize(300,750);  
        f.setLayout(null);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
