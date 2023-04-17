import java.util.Date;

public class External extends Member{
    //constructor
    External(String name, String email, String address, Date dob, long ssn, int memberId) {
        setName(name);
        setEmail(email);
        setAddress(address);
        setDateOfBirth(dob);
        setSSN(ssn);
        setMemberId(memberId);
        setBalance(0.0f);
    }
}
