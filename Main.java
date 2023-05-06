import java.util.ArrayList;
public class Main {
    // items
    public static ArrayList<Book> bookList = new ArrayList<Book>();
    public static ArrayList<Newspaper> newspaperList = new ArrayList<Newspaper>();
    public static ArrayList<Journal> journalList = new ArrayList<Journal>();
    public static ArrayList<Dvd> dvdList = new ArrayList<Dvd>();
    
    // member types
    public static ArrayList<Professor> professorList = new ArrayList<Professor>();
    public static ArrayList<Student> studentList = new ArrayList<Student>();
    public static ArrayList<External> externalList = new ArrayList<External>();
    
    // employee types
    public static ArrayList<Librarian> librarianList = new ArrayList<Librarian>();
    public static ArrayList<Technician> technicianList = new ArrayList<Technician>();
    
    // courses
    public static ArrayList<Course> courseList = new ArrayList<Course>();
    
    public static void main(String[] args) {
        StartMenu.startMenu();
    }
}
