abstract class Member extends Person{
    protected int MemberID;
    protected float Balance;

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
}
