import java.time.LocalDate;

public class Technician extends Employee {
    // Constructor with name, address, dob, email, ssn, employeeId, startDate, and salary parameters
    public Technician(String name, String address, LocalDate dob, String email, long ssn, int employeeId, LocalDate startDate, float salary) {
        setName(name);
        setAddress(address);
        setDateOfBirth(startDate);
        setEmail(email);
        setSSN(ssn);
        setEmployeeId(employeeId);
        setStartDate(dob);
        setSalary(salary);
    }
    
}
