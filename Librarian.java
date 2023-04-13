public class Librarian extends Employee {

    public void newItem(String section, String title, String author, String publisher, String status, int itemID){
        /*setSection(section);
        setTitle(title);
        setAuthor(author);
        setPublisher(publisher);
        setStatus("Shelved");
        setitemID(itemID); */
    }
    
    public Boolean isItemAvailable(String itemType, String section, String title){
        //go through database to find the title of a certain item in a certain section
        Boolean result = false;
        //String status = getStatus();

        if(status == "Shelved"){
            result = true;
        }

        return result;
    }

    //public Boolean isPersonMember(String position, String name, String dob){
        //go through database in certain section to find name
    }


}
