import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;

public class CheckOverdues {
    public static void changeToCheckOverdues(JFrame oldFrame) {
        oldFrame.setVisible(false);
        checkOverdues();
    }

    public static void checkOverdues() {
        JFrame f = new JFrame("Check Overdues");
        f.setVisible(true);

        JLabel memberIDLabel = new JLabel("Member ID");
        JTextField memberidInput = new JTextField();

        JButton checkButton = new JButton("Check");
        checkButton.setBounds(50, 50, 60, 20);
        f.add(checkButton);
        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{
                    long id = Integer.parseInt(memberIDLabel.getText());
                    if (id < 0)
                        throw new Exception();
                    JPanel panel = new JPanel();
                    OverdueBooksTable table = new OverdueBooksTable();
                    JScrollPane scrollPane = new JScrollPane(table.getTable());
                    panel.add(table);
                    f.setContentPane(panel);
                    ArrayList<Item> item = new ArrayList<>();
                    table.setOverdueBooks(item);
                }
                catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(f,
                            "Error! One of the items you inputted was formatted incorrectly. Please try again.");
                }
            }
        });

        JButton menuButton = new JButton("Menu");
        menuButton.setBounds(0, 0, 75, 20);
        f.add(menuButton);
        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                StartMenu.changeToStartMenu(f);
            }   
        });
        

        f.setSize(300,750);  
        f.setLayout(null);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
