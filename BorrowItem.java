import javax.swing.*;
import java.awt.event.*;

public class BorrowItem {
    public static void changeToBorrowItem(JFrame oldFrame) {
        oldFrame.setVisible(false);
        borrowItem();
    }

    public static void borrowItem() {
        JFrame f = new JFrame("Borrow Item");
        f.setVisible(true);

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
