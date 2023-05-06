import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;


public class StartMenu {
    // items
    ArrayList<Book> bookList = new ArrayList<Book>();
    ArrayList<Newspaper> newspaperList = new ArrayList<Newspaper>();
    ArrayList<Journal> journalList = new ArrayList<Journal>();
    ArrayList<Dvd> dvdList = new ArrayList<Dvd>();
    
    // member types
    ArrayList<Professor> professorList = new ArrayList<Professor>();
    ArrayList<Student> studentList = new ArrayList<Student>();
    ArrayList<External> externalList = new ArrayList<External>();
    
    // employee types
    ArrayList<Librarian> librarianList = new ArrayList<Librarian>();
    ArrayList<Technician> technicianList = new ArrayList<Technician>();
    
    // courses
    ArrayList<Course> courseList = new ArrayList<Course>();


    public static void createButton (JButton button, JFrame frame, int yInc) {
        button.setBounds(50,yInc,150,30);  
        frame.add(button);
    }

    public static void startMenu(){
        JFrame f=new JFrame("Button Example");
        JButton newMembershipButton=new JButton("New Membership");
        JButton newCollectionButton = new JButton("New Collection");
        JButton removeMembershipButton =new JButton("Remove Membership");
        JButton removeItemFromCollectionButton = new JButton("Remove Item from Collection");
        JButton newEmployeeButton = new JButton("New Employee");
        JButton borrowItemButton = new JButton("Borrow Item");
        JButton returnItemButton = new JButton("Return Item");
        JButton checkOverduesButton = new JButton("Check Overdues");
        JButton editInformationButton = new JButton("Edit Information");

        JButton buttons[] = {newMembershipButton, newCollectionButton, removeMembershipButton, removeItemFromCollectionButton, newEmployeeButton, borrowItemButton, returnItemButton, checkOverduesButton, editInformationButton};

        int yInc = 50;
        int yButton = 50;
        for (JButton button : buttons) {
            createButton(button, f, yButton);
            yButton += yInc;
        }

        newMembershipButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){  
                NewMembership.changeToMembershipFrame(f);
            }   
        });
    
        f.setSize(300,750);  
        f.setLayout(null);  
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
