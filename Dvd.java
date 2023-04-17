public class Dvd extends Item{
    Dvd(String section, String title, String author, String publisher, long itemID) {
        setSection(section);
        setTitle(title);
        setAuthor(author);
        setPublisher(publisher);
        setStatus("Shelved");
        setItemID(itemID);
    }
}