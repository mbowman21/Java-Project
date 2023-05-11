import javax.swing.*;
import java.awt.event.*;

public class RemoveItemFromCollection {
    public static void changeToRemoveItemFromCollection(JFrame oldFrame) {
        oldFrame.setVisible(false);
        removeItemFromCollection();
    }

    public static void removeItemFromCollection() {
        JFrame f = new JFrame("Remove Item From Collection");
        f.setVisible(true);

        //labels and inputs for things
        JLabel collectionLabel              = new JLabel("Collection:");
        String collections[]                = {"Book", "Dvd", "Journal", "Newspaper"};
        JComboBox<String> collectionInput   = new JComboBox<>(collections);

        JLabel itemIdLabel         = new JLabel("Enter the item's ID:");
        JTextField itemIdInput     = new JTextField();

        JButton submitButton = new JButton("Submit");

        // creating and adding all of the labels and inputs to the page
        JButton menuButton = new JButton("Menu");
        menuButton.setBounds(0, 0, 75, 20);
        f.add(menuButton);
        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                StartMenu.changeToStartMenu(f);
            }   
        });

        collectionLabel.setBounds(50, 30, 150, 20);
        f.add(collectionLabel);
        collectionInput.setBounds(50, 50, 150, 30);
        f.add(collectionInput);

        itemIdLabel.setBounds(50, 80, 150, 20);
        f.add(itemIdLabel);
        itemIdInput.setBounds(50, 100, 150, 30);
        f.add(itemIdInput);

        submitButton.setBounds(50, 140, 150, 30);
        f.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    String collection   = collectionInput.getItemAt(collectionInput.getSelectedIndex());
                    long itemId         = Long.parseLong(itemIdInput.getText());

                    if (itemId < 0 || itemId > 10000000000000L)
                            throw new Exception();

                    if (collection == "Book") {
                        for (Book book : Main.bookList) {
                            if (book.itemID == itemId){
                                Main.bookList.remove(book);
                                //print("Book successfully removed");
                            } 
                        }
                    }

                    if (collection == "Dvd") {
                        for (Dvd dvd : Main.dvdList) {
                            if (dvd.itemID == itemId){
                                Main.dvdList.remove(dvd);
                              //  print("Dvd successfully removed");
                            } 
                        }
                    }

                    if (collection == "Newspaper") {
                        for (Newspaper newspaper : Main.newspaperList) {
                            if (newspaper.itemID == itemId){
                                Main.newspaperList.remove(newspaper);
                              //  print("Newspaper successfully removed");
                            } 
                        }
                    }

                    if (collection == "Journal") {
                        for (Journal journal : Main.journalList) {
                            if (journal.itemID == itemId){
                                Main.journalList.remove(journal);
                              //  print("Journal successfully removed");
                            } 
                        }
                    }
                    
                } catch(Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(f,"Error! Item not found.");
                }
            }
        });

        f.setSize(300,750);  
        f.setLayout(null);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}