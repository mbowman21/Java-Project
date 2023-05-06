import java.time.LocalDate;
abstract class Employee extends Person{
    protected int employeeId;
    protected LocalDate startDate;
    protected float salary;

    public void setEmployeeId(int employeeId){
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return this.employeeId;
    }

    public void setStartDate(LocalDate startDate){
        this.startDate = startDate;
    }
    
    public LocalDate getStartDate() {
        return this.startDate;
    }
    
    public void setSalary(float salary){
        this.salary = salary;
    }

    public float getSalary() {
        return this.salary;
    }
}
