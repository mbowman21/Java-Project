import javax.swing.*;
import java.awt.event.*;

public class RemoveMembership {
    public static void changeToRemoveMembership(JFrame oldFrame) {
        oldFrame.setVisible(false);
        removeMembership();
    }

    public static void removeMembership() {
        JFrame f = new JFrame("Remove Membership");
        f.setVisible(true);

        
        
        // creating and adding all of the labels and inputs to the page
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
