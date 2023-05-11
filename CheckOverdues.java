import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.util.ArrayList;

public class CheckOverdues {
    public static void changeToCheckOverdues(JFrame oldFrame) {
        oldFrame.setVisible(false);
        checkOverdues();
    }

    public static void checkOverdues() {
        JFrame f = new JFrame("Check Overdues");
        f.setVisible(true);

        JButton checkButton = new JButton("Check");
        checkButton.setBounds(50, 50, 60, 20);
        f.add(checkButton);

        JLabel memberIDLabel = new JLabel("Member ID");
        JTextField memberidInput = new JTextField();
        memberIDLabel.setBounds(50, 80, 60, 20);
        f.add(memberIDLabel);

        memberidInput.setBounds(50, 100, 60, 30);
        f.add(memberidInput);

        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                try{
                    long id = Integer.parseInt(memberIDLabel.getText());
                    if (id < 0)
                        throw new Exception();
                    JPanel panel = new JPanel();
                    OverdueItemsTable table = new OverdueItemsTable();
                    JScrollPane scrollPane = new JScrollPane(table.getTable());
                    panel.add(table);
                    f.setContentPane(panel);
                    ArrayList<Item> item = new ArrayList<Item>();
                    table.setOverdueItems(item);
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
