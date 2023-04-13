public class Journal extends Item{
    Journal(String section, String title, String author, String publisher, int itemID){
        setSection(section);
        setTitle(title);
        setAuthor(author);
        setPublisher(publisher);
        setStatus("Shelved");
        setItemID(itemID);
    }
}