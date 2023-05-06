import java.time.LocalDate;

public class External extends Member{
    //constructor
    External(String name, LocalDate DOB, String email, int memberId, String address, long ssn) {
        setName(name);
        setEmail(email);
        setAddress(address);
        setDateOfBirth(DOB);
        setSSN(ssn);
        setMemberId(memberId);
        setBalance(0.0f);
    }
}
