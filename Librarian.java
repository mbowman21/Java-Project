import java.time.LocalDate;
public class Librarian extends Employee {
    public Librarian(String name, String address, LocalDate dob, String email, long ssn, int employeeId, LocalDate startDate, float salary) {
        setName(name);
        setAddress(address);
        setDateOfBirth(startDate);
        setEmail(email);
        setSSN(ssn);
        setEmployeeId(employeeId);
        setStartDate(dob);
        setSalary(salary);

    }

    public Book newBook(String type, String section, String title, String author, String publisher, int itemID){
        Book newBook = new Book(section, title, author, publisher, itemID);
        return newBook;
    }
    
    public Dvd newDvd(String type, String section, String title, String author, String publisher, int itemID){
        Dvd newDvd = new Dvd(section, title, author, publisher, itemID);
        return newDvd;
    }
    
    public Journal newJournal(String type, String section, String title, String author, String publisher, int itemID){
        Journal newJournal = new Journal(section, title, author, publisher, itemID);
        return newJournal;
    }
    
    public Newspaper newNewspaper(String type, String section, String title, String author, String publisher, int itemID){
        Newspaper newNewspaper = new Newspaper(section, title, author, publisher, itemID);
        return newNewspaper;
    }

}
