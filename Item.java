import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.Duration;

abstract class Item {
    protected String section;
    protected String title;
    protected String author;
    protected String publisher;
    protected String status;
    protected long itemID;
    protected LocalDate checkoutDate;
    protected long memberId;

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

    public LocalDate getCheckoutDate(){
        return this.checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate){
        this.checkoutDate = checkoutDate;
    }

    public long getMemberId(){
        return this.memberId;
    }
    public void checkout(Member m){
        this.checkoutDate = LocalDate.now();
        this.memberId = m.getMemberId();
    } 

    public boolean isOverdue(){
        if(this.checkoutDate==null){
            return false;
        }
        LocalDateTime now = LocalDateTime.now().plus(15,ChronoUnit.DAYS);//".plusDays(15) exists only to test the item being overdue"
        Duration duration = Duration.between(this.checkoutDate, now);
        if(duration.toDays() > 14){
            return true;
        }
        else{
            return false;
        }
    }

    public Long getDaysOverdue(){
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(this.checkoutDate,now);
        Long DaysOverdue = duration.toDays();
        return DaysOverdue;
    }
}
