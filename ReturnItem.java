import javax.swing.*;
import java.awt.event.*;

public class ReturnItem {
    public static void changeToReturnItem(JFrame oldFrame) {
        oldFrame.setVisible(false);
        returnItem();
    }

    public static void returnItem() {
        JFrame f = new JFrame("Return Item");
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
