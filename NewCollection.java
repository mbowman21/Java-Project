import javax.swing.*;
import java.awt.event.*;
public class NewCollection {
    // create text fields
    public static void createTextField (JTextField textField, JFrame frame, int y) {
        textField.setBounds(50,y,150,30);  
        frame.add(textField);
    }

    // creates labels
    public static void createLabel(JLabel label, JFrame frame, int y) {
        label.setBounds(50, y, 150, 20);
        frame.add(label);
    }

    public static void changeToNewCollection(JFrame oldFrame) {
        oldFrame.setVisible(false);
        newCollection();
    }

    public static void newCollection() {
        JFrame f = new JFrame("New Collection Creation");
        f.setVisible(true);

        //labels and inputs for things
        JLabel collectionLabel              = new JLabel("Collection:");
        String collections[]                = {"Book", "Dvd", "Journal", "Newspaper"};
        JComboBox<String> collectionInput   = new JComboBox<>(collections);

        JLabel sectionLabel         = new JLabel("Section:");
        JLabel titleLabel           = new JLabel("Title:");
        JLabel authorLabel          = new JLabel("Author:");
        JLabel publisherLabel       = new JLabel("Publisher:");  
        JLabel itemIdLabel          = new JLabel("ItemID: ");
        
        JTextField sectionInput     = new JTextField();
        JTextField titleInput       = new JTextField();
        JTextField authorInput      = new JTextField();
        JTextField publisherInput   = new JTextField();
        JTextField itemIdInput      = new JTextField();

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

        int yLabel = 90;
        int yInput = 110;
        int yInc = 60;

        JLabel labels[] = {sectionLabel, titleLabel, authorLabel, publisherLabel, itemIdLabel};
        for (JLabel label : labels) {
            createLabel(label, f, yLabel);
            yLabel += yInc;
        }

        JTextField textFields[] = {sectionInput, titleInput, authorInput, publisherInput, itemIdInput};
        for (JTextField textField : textFields) {
            createTextField(textField, f, yInput);
            yInput += yInc;
        }

        submitButton.setBounds(50, 400, 150, 30);
        f.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    String collection = collectionInput.getItemAt(collectionInput.getSelectedIndex());
                    String section      = sectionInput.getText();
                    String title        = titleInput.getText();
                    String author       = authorInput.getText();
                    String publisher    = publisherInput.getText();
                    long itemId         = Long.parseLong(itemIdInput.getText());

                    if (section.isEmpty() || title.isEmpty() || author.isEmpty() || publisher.isEmpty())
                        throw new Exception();
                
                    if (collection == "Book") {
                        if (itemId < 0 || itemId > 10000000000000L)
                            throw new Exception();
                        
                        for (Book book : Main.bookList) {
                            if (book.itemID == itemId)
                                throw new Exception();
                        }
                        
                        Book newBook = new Book(section, title, author, publisher, itemId);
                        Main.bookList.add(newBook);
                    }

                    if (collection == "Dvd") {
                        if (itemId < 0 || itemId > 10000000000000L)
                            throw new Exception();

                        for (Dvd dvd : Main.dvdList) {
                            if (dvd.itemID == itemId)
                                throw new Exception();
                        }
                        
                        Dvd newDvd = new Dvd(section, title, author, publisher, itemId);
                        Main.dvdList.add(newDvd);
                    }

                    if (collection == "Journal") {
                        if (itemId < 0 || itemId > 1000000000L)
                            throw new Exception();

                        for (Journal journal : Main.journalList) {
                            if (journal.itemID == itemId)
                                throw new Exception();
                        }

                        Journal newJournal = new Journal(section, title, author, publisher, itemId);
                        Main.journalList.add(newJournal);
                    }

                    if (collection == "Newspaper") {
                        if (itemId < 0 || itemId > 1000000000L)
                            throw new Exception();

                        for (Newspaper newspaper : Main.newspaperList) {
                            if (newspaper.itemID == itemId)
                                throw new Exception();
                        }

                        Newspaper newNewspaper = new Newspaper(section, title, author, publisher, itemId);
                        Main.newspaperList.add(newNewspaper);
                    }

                    
                } catch(Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(f,"Error! One of the items you inputted was formatted incorrectly. Please try again.");
                }
            }
        });
        
        f.setSize(300,750);  
        f.setLayout(null);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
