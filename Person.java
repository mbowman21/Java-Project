import java.util.Date;

abstract class Person {
    protected String name;
    protected String address;
    protected Date dob;
    protected String email;
    protected long ssn;

    public String toString(){

    }

    public void setName(String name) {
        this.name = name;
    }

    
    public void setAddress(String address) {
        this.address = address;
    }
    public void setDateOfBirth(Date date) {
        this.dob = date;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setSSN(long ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public Date getDate() {
        return this.dob;
    }

    public String getEmail() {
        return this.email;
    }

    public long getSSN() {
        return this.ssn;
    }
}