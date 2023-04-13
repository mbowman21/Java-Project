public class Librarian extends Employee {

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
    
    public Boolean isItemAvailable(String itemType, String section, int itemID){
        //go through database to find the title of a certain item in a certain section
        Boolean result = false;
        //String status = getStatus();

        if(status == "Shelved"){
            result = true;
        }

        return result;
    }

    public Boolean isPersonMember(String position, String name, String dob){
        //go through database in certain section to find name
    }


}
