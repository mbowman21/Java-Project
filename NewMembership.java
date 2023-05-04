import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.*;

public class NewMembership {

    public static void changeToMembershipFrame(JFrame oldFrame){
        oldFrame.setVisible(false);

        JFrame f = new JFrame("New Membership Creation");
        f.setVisible(true);

        JTextField name = new JTextField();
        name.setBounds(50,50,50,50);
        f.add(name);


        f.setSize(300,750);  
        f.setLayout(null);  
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void createNewStudent(ArrayList<Student> studentList){}

    public static void createNewProfessor(ArrayList<Professor> professorList){
        
    }
    public static void createNewExternal(ArrayList<External> externalList){
        
    }
}
