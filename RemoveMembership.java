import javax.swing.*;
import java.awt.event.*;

public class RemoveMembership {
    // changes from the oldframe to the new frame
    public static void changeToRemoveMembership(JFrame oldFrame) {
        oldFrame.setVisible(false);
        removeMembership();
    }

    public static void removeMembership() {
        // create the frame
        JFrame f = new JFrame("Remove Membership");
        f.setVisible(true);
        
        // menu button
        JButton menuButton = new JButton("Menu");
        menuButton.setBounds(0, 0, 75, 20);
        f.add(menuButton);
        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                StartMenu.changeToStartMenu(f);
            }
        });

        // labels and inputs
        JLabel typeLabel = new JLabel("Type of Member:");
        String types[] = {"Professor", "Student", "External"};
        JComboBox<String> typeInput = new JComboBox<>(types);

        JLabel idLabel = new JLabel("Id:");
        JTextField idInput = new JTextField();

        JButton submit = new JButton("Submit");

        // setting bounds and adding them to the page
        typeLabel.setBounds(50, 30, 150, 20);
        f.add(typeLabel);

        typeInput.setBounds(50, 50, 150, 30);
        f.add(typeInput);

        idLabel.setBounds(50, 90, 150, 20);
        f.add(idLabel);
        idInput.setBounds(50, 110, 150, 30);
        f.add(idInput);

        submit.setBounds(50, 150, 150, 30);
        f.add(submit);

        // submits the information
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // if anything throws an error then it will print an error message
                try {
                    String type = typeInput.getItemAt(typeInput.getSelectedIndex());
                    int id = Integer.parseInt(idInput.getText());
                    if (id < 0)
                        throw new Exception();

                    if (type == "Student") {
                        for (Student student : Main.studentList) {
                            if (student.getMemberId() == id) {
                                Main.studentList.remove(student);
                                JOptionPane.showMessageDialog(f,
                                "Student successfully deleted!");
                                idInput.setText("");
                                return;
                            }
                        }
                    }

                    else if (type == "Professor") {
                        for (Professor professor : Main.professorList) {
                            if (professor.getMemberId() == id) {
                                Main.professorList.remove(professor);
                                JOptionPane.showMessageDialog(f,
                                "Professor successfully deleted!");
                                idInput.setText("");
                                return;
                            }
                        }
                    }

                    else if (type == "External") {
                        for (External external : Main.externalList) {
                            if (external.getMemberId() == id) {
                                Main.externalList.remove(external);
                                JOptionPane.showMessageDialog(f,
                                "External successfully deleted!");
                                idInput.setText("");
                                return;
                            }
                        }
                        throw new Exception();
                    }
                    
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(f,
                            "Error! One of the items you inputted was formatted incorrectly and/or that id does not exist. Please try again.");

                }
            }
        });




        f.setSize(300,750);  
        f.setLayout(null);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
