import java.util.ArrayList;

abstract class Member extends Person{
    protected int MemberID;
    protected float Balance;
    protected ArrayList<Item> CheckoutHistory;

    public void setMemberId(int id) {
        this.MemberID = id;
    }

    public void setBalance(float balance) {
        this.Balance = balance;
    }

    public int getMemberId() {
        return this.MemberID;
    }

    public float getBalance() {
        return this.Balance;
    }

    public void checkoutItem(Item i){
        this.CheckoutHistory.add(i.itemID);
    }

    public ArrayList<Item> getOverdueList(){
        ArrayList<Item> overdues = new ArrayList<Item>();
        for(i in length(this.CheckoutHistory)){
            if(this.CheckoutHistory[i].isOverdue()==true){
                overdues.add(this.CheckoutHistory[i]);
            }
        }
        return overdues;
    }
}
