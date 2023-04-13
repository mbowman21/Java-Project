import java.util.Date;
abstract class Employee extends Person{
    protected int employeeId;
    protected Date startDate;
    protected float salary;

    public void setEmployeeId(int employeeId){
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return this.employeeId;
    }

    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }
    
    public Date getStartDate() {
        return this.startDate;
    }
    
    public void setSalary(float salary){
        this.salary = salary;
    }

    public float getSalary() {
        return this.salary;
    }
}
