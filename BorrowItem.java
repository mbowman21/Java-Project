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

        JLabel itemLabel = new JLabel("Item Type:");
        String items[] = {"Book", "Dvd", "Journal", "Newspaper"};
        JComboBox<String> itemInput = new JComboBox<>(items);

        JLabel idLabel = new JLabel("Item ID: ");
        JTextField idInput = new JTextField();

        JButton submitBorrowButton = new JButton("Submit Borrow");

        JButton menuButton = new JButton("Menu");
        menuButton.setBounds(0, 0, 75, 20);
        f.add(menuButton);
        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                StartMenu.changeToStartMenu(f);
            }   
        });
        
        itemLabel.setBounds(50, 30, 150, 20);
        f.add(itemLabel);
        itemInput.setBounds(50, 50, 150, 30);
        f.add(itemInput);

        idLabel.setBounds(50, 80, 150, 20);
        f.add(idLabel);
        idInput.setBounds(50, 100, 150, 20);
        f.add(idInput);

        submitBorrowButton.setBounds(50, 200, 150, 30);
        f.add(submitBorrowButton);

        submitBorrowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {

                    String item = itemInput.getItemAt(itemInput.getSelectedIndex());
                    long itemID = Long.parseLong(idInput.getText());

                    if (item.isEmpty())
                        throw new Exception();

                    if (itemID < 0 || itemID > 10000000000L)
                        throw new Exception();

                } catch(Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(f,"Error! Please try again.");
                }
            }
        });


        f.setSize(300,750);  
        f.setLayout(null);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
