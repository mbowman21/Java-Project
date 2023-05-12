import javax.swing.*;
import java.awt.event.*;




public class ReturnItem {

    public static void createTextField (JTextField textField, JFrame frame, int y) {
        textField.setBounds(50,y,150,30);  
        frame.add(textField);
    }

    // creates labels
    public static void createLabel(JLabel label, JFrame frame, int y) {
        label.setBounds(50, y, 150, 20);
        frame.add(label);
    }

    public static void changeToReturnItem(JFrame oldFrame) {
        oldFrame.setVisible(false);
        returnItem();
    }

    public static void returnItem() {
        JFrame f = new JFrame("Return Item");
        f.setVisible(true);

        JLabel itemLabel = new JLabel("Item Type:");
        String items[] = {"Book", "Dvd", "Journal", "Newspaper"};
        JComboBox<String> itemInput = new JComboBox<>(items);

        JLabel idLabel = new JLabel("Item ID: ");
        JTextField idInput = new JTextField();

        JButton submitReturnButton = new JButton("Submit Return");

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

        submitReturnButton.setBounds(50, 200, 150, 30);
        f.add(submitReturnButton);


        submitReturnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {

                    String item = itemInput.getItemAt(itemInput.getSelectedIndex());
                    long itemID = Long.parseLong(idInput.getText());

                    if (item.isEmpty())
                        throw new Exception();

                    if (itemID < 0 || itemID > 10000000000L)
                        throw new Exception();
                    
                    if (itemInput.getItemAt(itemInput.getSelectedIndex()) == "Book") {
                        for (Book book : Main.bookList){
                            if (book.getItemID() == itemID)
                                {
                                    book.setStatus("Shelved");
                                    book.setMemberId(0);
                                }
                                else{
                                    throw new Exception();
                                }
                        }
                    }
                    else if (itemInput.getItemAt(itemInput.getSelectedIndex()) == "Dvd") {
                        for (Dvd dvd : Main.dvdList){
                            if (dvd.getItemID() == itemID)
                                {
                                    dvd.setStatus("Shelved");
                                    dvd.setMemberId(0);
                                }
                                else{
                                    throw new Exception();
                                }
                        }
                    }
                    else if (itemInput.getItemAt(itemInput.getSelectedIndex()) == "Journal") {
                        for (Journal journal : Main.journalList){
                            if (journal.getItemID() == itemID)
                                {
                                    journal.setStatus("Shelved");
                                    journal.setMemberId(0);
                                }
                            else{
                                    throw new Exception();
                                }
                        }
                    }
                    else if (itemInput.getItemAt(itemInput.getSelectedIndex()) == "Newspaper") {
                        for (Newspaper newspaper : Main.newspaperList){
                            if (newspaper.getItemID() == itemID)
                                {
                                    newspaper.setStatus("Shelved");
                                    newspaper.setMemberId(0);
                                }
                            else{
                                throw new Exception();
                            }
                        }
                    }
                } catch(Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(f,"Error! One of the items you inputted was formatted incorrectly and/or we do not own that item at our library. Please try again.");
                }
            }
        });

        f.setSize(300,750);  
        f.setLayout(null);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
