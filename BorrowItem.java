import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BorrowItem {
    
    public static void changeToBorrowItem(JFrame oldFrame) {
        int oldFrameWidth = oldFrame.getWidth();
        int oldFrameHeight = oldFrame.getHeight();
        oldFrame.setVisible(false);
        borrowItem(oldFrameWidth, oldFrameHeight);
    }

    public static void borrowItem(int frameWidth, int frameHeight) {
        JFrame f = new JFrame("Borrow Item");
        f.setSize(frameWidth, frameHeight);

        JLabel collectionLabel = new JLabel("Collection:");
        String collections[] = {"Book", "Dvd", "Journal", "Newspaper"};
        JComboBox<String> collectionInput = new JComboBox<>(collections);

        JLabel itemIdLabel = new JLabel("Enter the item's ID:");
        JTextField itemIdInput = new JTextField();

        JLabel memberIdLabel = new JLabel("Enter your Member ID:");
        JTextField memberIdInput = new JTextField();

        JButton submitButton = new JButton("Submit");

        JButton menuButton = new JButton("Menu");
        menuButton.setBounds(0, 0, 75, 20);
        f.add(menuButton);
        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StartMenu.changeToStartMenu(f);
            }
        });

        collectionLabel.setBounds(50, 30, 150, 20);
        f.add(collectionLabel);
        collectionInput.setBounds(50, 50, 200, 30);
        f.add(collectionInput);

        itemIdLabel.setBounds(50, 80, 250, 20);
        f.add(itemIdLabel);
        itemIdInput.setBounds(50, 100, 300, 30);
        f.add(itemIdInput);

        memberIdLabel.setBounds(50, 130, 250, 20);
        f.add(memberIdLabel);
        memberIdInput.setBounds(50, 150, 300, 30);
        f.add(memberIdInput);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    String collection = collectionInput.getItemAt(collectionInput.getSelectedIndex());
                    long itemId = Long.parseLong(itemIdInput.getText());
                    int memberId = Integer.parseInt(memberIdInput.getText());
                    
                    Member borrower = null;
                    ArrayList<Member> allMembers = new ArrayList<>();
                    allMembers.addAll(Main.professorList);
                    allMembers.addAll(Main.studentList);
                    allMembers.addAll(Main.externalList);
                    for (Member member : allMembers) {
                        if (member.getMemberId() == memberId) {
                            borrower = member;
                            break;
                        }
                    }
                    
                    if (borrower == null) {
                        throw new Exception("Member not found.");
                    }

                    Item itemToBorrow = null;
                    switch(collection) {
                        case "Book":
                            for (Book book : Main.bookList) {
                                if (book.getItemID() == itemId) {
                                    itemToBorrow = book;
                                    break;
                                }
                            }
                            break;
                        case "Dvd":
                            for (Dvd dvd : Main.dvdList) {
                                if (dvd.getItemID() == itemId) {
                                    itemToBorrow = dvd;
                                    break;
                                }
                            }
                            break;
                        case "Newspaper":
                            for (Newspaper newspaper : Main.newspaperList) {
                                if (newspaper.getItemID() == itemId) {
                                    itemToBorrow = newspaper;
                                    break;
                                }
                            }
                            break;
                        case "Journal":
                            for (Journal journal : Main.journalList) {
                                if (journal.getItemID() == itemId) {
                                    itemToBorrow = journal;
                                    break;
                                }
                            }
                            break;
                    }

                    if (itemToBorrow == null) {
                        throw new Exception("Item not found.");
                    }

                    itemToBorrow.checkout(borrower);
                    borrower.checkoutItem(itemToBorrow);

                    JOptionPane.showMessageDialog(f,"Item successfully borrowed!");

                } catch(Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(f,"Error! " + e.getMessage());
                }
            }
        });

        submitButton.setBounds(50, 180, 300, 30);
        f.add(submitButton);

        f.setLayout(null);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}

