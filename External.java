import java.util.Date;

public class External extends Member{
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
