import javax.swing.*;
import java.awt.event.*;


public class StartMenu {
    public static void changeToStartMenu(JFrame oldFrame) {
        oldFrame.setVisible(false);
        startMenu();
    }

    public static void createButton (JButton button, JFrame frame, int yInc) {
        button.setBounds(50,yInc,200,30);  
        frame.add(button);
    }

    public static void startMenu(){
        JFrame f=new JFrame("Start Menu");
        f.setVisible(true);

        JButton newMembershipButton=new JButton("New Membership");
        JButton newCollectionButton = new JButton("New Collection");
        JButton removeMembershipButton =new JButton("Remove Membership");
        JButton removeItemFromCollectionButton = new JButton("Remove Item from Collection");
        JButton newEmployeeButton = new JButton("New Employee");
        JButton borrowItemButton = new JButton("Borrow Item");
        JButton returnItemButton = new JButton("Return Item");
        JButton checkOverduesButton = new JButton("Check Overdues");

        JButton buttons[] = {newMembershipButton, newCollectionButton, removeMembershipButton, removeItemFromCollectionButton, newEmployeeButton, borrowItemButton, returnItemButton, checkOverduesButton};

        int yInc = 50;
        int yButton = 50;
        for (JButton button : buttons) {
            createButton(button, f, yButton);
            yButton += yInc;
        }

        newMembershipButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){  
                NewMembership.changeToNewMembership(f);
            }   
        });

        newCollectionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){  
                NewCollection.changeToNewCollection(f);
            }   
        });

        newEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){  
                NewEmployee.changeToNewEmployee(f);
            }   
        });

        removeItemFromCollectionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){  
                RemoveItemFromCollection.changeToRemoveItemFromCollection(f);
            }   
        });

        borrowItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){  
                BorrowItem.changeToBorrowItem(f);
            }   
        });

        returnItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){  
                ReturnItem.changeToReturnItem(f);
            }   
        });

        checkOverduesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){  
                CheckOverdues.changeToCheckOverdues(f);
            }   
        });

        removeMembershipButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){  
                RemoveMembership.changeToRemoveMembership(f);
            }   
        });
    
        f.setSize(350,750);  
        f.setLayout(null);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
