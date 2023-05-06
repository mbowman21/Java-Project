import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.*;

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
        JLabel ssnLabel = new JLabel("SSN:");

        JTextField nameInput = new JTextField();
        JTextField emailInput = new JTextField();
        JTextField idInput = new JTextField();
        JTextField addressInput = new JTextField();
        JTextField ssnInput = new JTextField();

        JLabel monthLabel = new JLabel("Month:");
        String months[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        JComboBox<String> monthInput = new JComboBox<>(months);

        JLabel dayLabel = new JLabel("Day:");
        String days[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        JComboBox<String> dayInput = new JComboBox<>(days);

        JLabel yearLabel = new JLabel("Year:");
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
            public void actionPerformed(ActionEvent e) {
                String name = nameInput.getText();
                String email = emailInput.getText();
                String id = idInput.getText();
                String address = addressInput.getText();
                String ssn = ssnInput.getText();
                String month = monthInput.getItemAt(monthInput.getSelectedIndex());
                String day = dayInput.getItemAt(dayInput.getSelectedIndex());
                String year = yearInput.getText();
                if (typeInput.getItemAt(typeInput.getSelectedIndex()) == "Student") {

                } else if (typeInput.getItemAt(typeInput.getSelectedIndex()) == "Professor") {

                } else if (typeInput.getItemAt(typeInput.getSelectedIndex()) == "External") {

                }
            }
        });


        f.setSize(300,750);  
        f.setLayout(null);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void createNewStudent(ArrayList<Student> studentList){

    }

    public static void createNewProfessor(ArrayList<Professor> professorList){
        
    }
    public static void createNewExternal(ArrayList<External> externalList){
        
    }
}
