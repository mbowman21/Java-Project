import java.util.Date;

abstract class Item {
    protected String section;
    protected String title;
    protected String author;
    protected String publisher;
    protected String status;
    protected long itemID;
    protected Date checkoutDate;

    public String getSection() {
        return this.section;
    }

    public void setSection(String section){
        this.section = section;
    }
    
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author){
        this.author = author;
    }
    
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getPublisher(){
        return this.publisher;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    public long getItemID() {
        return this.itemID;
    }

    public void setItemID(long itemID){
        this.itemID = itemID;
    }

    public Date getCheckoutDate(){
        return this.checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate){
        this.checkoutDate = checkoutDate;
    }

}
