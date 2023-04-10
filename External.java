import java.util.Date;

public class External extends Member{
    //getters and setters
    //!! put in Member class?
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

    

    //constructor
    External(String name, String email, String address, Date dob, int ssn) {
        setName(name);
        setEmail(email);
        setAddress(address);
        setDateOfBirth(dob);
        setSSN(ssn);
        setMemberId(0);  //!! make an id thing
        setBalance(0.0f);
    }



}
