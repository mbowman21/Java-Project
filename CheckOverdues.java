import javax.swing.*;

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
        checkButton.setBounds(50, 80, 100, 20);
        checkButton.setFocusable(false);
        f.add(checkButton);

        JLabel memberIDLabel = new JLabel("Member ID");
        JTextField memberidInput = new JTextField();
        memberIDLabel.setBounds(50, 50, 100, 20);
        f.add(memberIDLabel);

        memberidInput.setBounds(50, 100, 200, 30);
        f.add(memberidInput);

        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                try{
                    
                    long id = Integer.parseInt(memberidInput.getText());
                    if (id < 0 || id > 10000000000000L){
                        throw new Exception();
                    }
                    JPanel panel = new JPanel();
                    OverdueItemsTable table = new OverdueItemsTable();
                    panel.add(table);
                    f.setContentPane(panel);
                    ArrayList<Item> items = new ArrayList<Item>();
                    ArrayList<Member> allMembers = new ArrayList<>();
                    allMembers.addAll(Main.professorList);
                    allMembers.addAll(Main.studentList);
                    allMembers.addAll(Main.externalList);
                    if(allMembers.isEmpty()){
                        throw new Exception();
                    }
                    for (Member member : allMembers) {
                        if (member.getMemberId() == id) {
                            for(Item i : member.CheckoutHistory){
                                items.add(i);
                            }
                            table.setOverdueItems(items);
                            break;
                        }
                        else{
                            throw new Exception();
                        }
                    }
                }
                catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(f,
                            "Error! Looks like you did not enter a valid member ID. Please try again");
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
