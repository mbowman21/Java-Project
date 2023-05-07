import javax.swing.*;
import java.awt.event.*;
import java.time.*;
public class NewEmployee {

    public static void createTextField (JTextField textField, JFrame frame, int y) {
        textField.setBounds(50,y,150,30);  
        frame.add(textField);
    }

    // creates labels
    public static void createLabel(JLabel label, JFrame frame, int y) {
        label.setBounds(50, y, 150, 20);
        frame.add(label);
    }
    public static void changeToNewEmployee(JFrame oldFrame){
        oldFrame.setVisible(false);
        newEmployee();
    }

    public static void newEmployee(){
        JFrame f = new JFrame("New Employee Creation");
        f.setVisible(true);

        JLabel nameLabel = new JLabel("Name:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel employeeIdLabel = new JLabel("Employee Id:");
        JLabel addressLabel = new JLabel("Address:");
        JLabel ssnLabel = new JLabel("SSN: (XXXXXXXXX)");
        JLabel salaryLabel = new JLabel("Salary:");

        JTextField nameInput = new JTextField();
        JTextField emailInput = new JTextField();
        JTextField employeeIdInput = new JTextField();
        JTextField addressInput = new JTextField();
        JTextField ssnInput = new JTextField();
        JTextField salaryInput = new JTextField();

        JLabel monthLabel = new JLabel("Birth Month:");
        String months[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        JComboBox<String> monthInput = new JComboBox<>(months);

        JLabel dayLabel = new JLabel("Birth Day:");
        String days[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        JComboBox<String> dayInput = new JComboBox<>(days);

        JLabel yearLabel = new JLabel("Birth Year: (YYYY)");
        JTextField yearInput = new JTextField();

        JLabel startMonthLabel = new JLabel("Start Month:");
        JComboBox<String> startMonthInput = new JComboBox<>(months);

        JLabel startDayLabel = new JLabel("Start Day:");
        JComboBox<String> startDayInput = new JComboBox<>(days);

        JLabel startYearLabel = new JLabel("Start Year: (YYYY)");
        JTextField startYearInput = new JTextField();

        JLabel employeeTypeLabel = new JLabel("Type of Employee:");
        String empTypes[] = {"Librarian", "Technician"};
        JComboBox<String> employeeTypeInput = new JComboBox<>(empTypes);

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

        JLabel labels[] = {nameLabel, emailLabel, employeeIdLabel, addressLabel, ssnLabel, salaryLabel};
        for (JLabel label : labels) {
            createLabel(label, f, yLabel);
            yLabel += yInc;
        }

        JTextField textFields[] = {nameInput, emailInput, employeeIdInput, addressInput, ssnInput, salaryInput};
            for (JTextField textField : textFields) {
                createTextField(textField, f, yInput);
                yInput += yInc;
            }

        //birth date info
        monthLabel.setBounds(300, 30, 150, 20);  
        f.add(monthLabel);
        monthInput.setBounds(300, 50, 150, 30);
        f.add(monthInput);

        dayLabel.setBounds(300, 90, 150, 20);
        f.add(dayLabel);
        dayInput.setBounds(300, 110, 150, 30);
        f.add(dayInput);

        yearLabel.setBounds(300, 150, 150, 20);
        f.add(yearLabel);
        yearInput.setBounds(300, 170, 150, 30);
        f.add(yearInput);

        //start date info
        startMonthLabel.setBounds(300, 210, 150, 20);  
        f.add(startMonthLabel);
        startMonthInput.setBounds(300, 230, 150, 30);
        f.add(startMonthInput);

        startDayLabel.setBounds(300, 270, 150, 20);
        f.add(startDayLabel);
        startDayInput.setBounds(300, 290, 150, 30);
        f.add(startDayInput);

        startYearLabel.setBounds(300, 330, 150, 20);
        f.add(startYearLabel);
        startYearInput.setBounds(300, 350, 150, 30);
        f.add(startYearInput);

        //employee type info
        employeeTypeLabel.setBounds(150, 390, 150, 20);
        f.add(employeeTypeLabel);
        employeeTypeInput.setBounds(150, 410, 150, 30);
        f.add(employeeTypeInput);

        submit.setBounds(150, 500, 150, 30);
        f.add(submit);

        submit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    try {
                        String name = nameInput.getText();
                        String email = emailInput.getText();
                        int employeeId = Integer.parseInt(employeeIdInput.getText());
                        if (employeeId < 0)
                            throw new Exception();
                        String address = addressInput.getText();
                        float salary = Float.parseFloat(salaryInput.getText());
                        if (salary < 0) 
                            throw new Exception();
                        long ssn = Long.parseLong(ssnInput.getText());
                        if (ssn < 0 || ssn > 10000000000L)
                            throw new Exception();
                        int month = Integer.parseInt(monthInput.getItemAt(monthInput.getSelectedIndex()));
                        int day = Integer.parseInt(dayInput.getItemAt(dayInput.getSelectedIndex()));
                        int year = Integer.parseInt(yearInput.getText());
                        if (year < 1900 || year > Year.now().getValue() )
                            throw new Exception();
                        LocalDate dob = LocalDate.of(year, month, day);


                        int startMonth = Integer.parseInt(startMonthInput.getItemAt(startMonthInput.getSelectedIndex()));
                        int startDay = Integer.parseInt(startDayInput.getItemAt(startDayInput.getSelectedIndex()));
                        int startYear = Integer.parseInt(startYearInput.getText());
                        if (startYear < 1900 || startYear > Year.now().getValue() )
                            throw new Exception();
                        LocalDate startDate = LocalDate.of(startYear, startMonth, startDay);

                        if (name.isEmpty() || email.isEmpty() || address.isEmpty())
                            throw new Exception();

                        if (employeeTypeInput.getItemAt(employeeTypeInput.getSelectedIndex()) == "Librarian") {
                            for (Librarian librarian : Main.librarianList){
                                if (librarian.getEmployeeId() == employeeId)
                                    throw new Exception();
                                if (librarian.getSSN() == ssn)
                                    throw new Exception();
                            }
                            Librarian newLibrarian = new Librarian(name, address, dob, email, ssn, employeeId, startDate, salary);
                            Main.librarianList.add(newLibrarian);
                            System.out.println(Main.librarianList);
                        }
                        
                        else if (employeeTypeInput.getItemAt(employeeTypeInput.getSelectedIndex()) == "Technician") {
                            for (Technician technician : Main.technicianList) {
                                if (technician.getEmployeeId() == employeeId)
                                    throw new Exception();
                                if (technician.getSSN() == ssn)
                                    throw new Exception();
                            }
                            Technician newTechnician = new Technician(name, address, dob, email, ssn, employeeId, startDate, salary);
                            Main.technicianList.add(newTechnician);
                            System.out.println(Main.technicianList);
                        }
                
                        else
                            throw new Exception();
                    } catch(Exception e) {
                        System.out.println(e);
                        JOptionPane.showMessageDialog(f,"Error! One of the items you inputted was formatted incorrectly and/or that employee id/ssn is already in use. Please try again.");
                    }
                }
            });

            f.setSize(600,800);  
            f.setLayout(null);  
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
