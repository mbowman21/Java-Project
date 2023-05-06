import java.time.LocalDate;

abstract class Person {
    protected String name;
    protected String address;
    protected LocalDate dob;
    protected String email;
    protected long ssn;

    //@Override
    public String toString(){
        return "Name: " + this.name + "\nAddress: " + this.address + "\nDate of Birth: " + this.dob.toString() + "\n Email: " + this.email + "\nSSN: " + String.valueOf(this.ssn);
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public void setAddress(String address) {
        this.address = address;
    }
    public void setDateOfBirth(LocalDate date) {
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

    public LocalDate getDate() {
        return this.dob;
    }

    public String getEmail() {
        return this.email;
    }

    public long getSSN() {
        return this.ssn;
    }
}