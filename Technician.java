import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Date;

public class Technician extends Employee {
    private List<Item> unshelvedItems;
    private String u="unshelved";//Stores the string object we will compare the status of the book to

    // Constructor with name, employeeId, startDate, and salary parameters
    public Technician(String name, int employeeId, Date startDate, float salary) {
        this.name=name;
        this.employeeId= employeeId;
        this.startDate = startDate;
        this.salary = salary;
    }

    // Constructor with name, address, dob, email, employeeId, startDate, and salary parameters
    public Technician(String name, String address, Date dob, String email, int employeeId, Date startDate, float salary) {
        this.name=name;
        this.address=address;
        this.dob=dob;
        this.email=email;
        this.employeeId=employeeId;
        this.startDate = startDate;
        this.salary = salary;
    }

    // Constructor with name, dob, email, ssn, employeeId, startDate, and salary parameters
    public Technician(String name, Date dob, String email, int ssn, int employeeId, Date startDate, float salary) {
        this.name=name;
        this.dob=dob;
        this.email=email;
        this.ssn=ssn;
        this.employeeId=employeeId;
        this.startDate = startDate;
        this.salary = salary;
    }

    // Constructor with name, address, dob, email, ssn, employeeId, startDate, and salary parameters
    public Technician(String name, String address, Date dob, String email, int ssn, int employeeId, Date startDate, float salary) {
        this.name=name;
        this.address=address;
        this.dob=dob;
        this.email=email;
        this.ssn=ssn;
        this.employeeId=employeeId;
        this.startDate = startDate;
        this.salary = salary;
    }

    
    //Adds item that needs to be reshelved
    public void addUnshelvedItem(Item i){
        if(i.getStatus().equals(u)){
            unshelvedItems.add(i);
        }
    }

    // Method to sort and shelve unshelved items
    public void shelveItems() {
        //Sort unshelved items by call number
        Collections.sort(unshelvedItems, new Comparator<Item>() {
            public int compare(Item i1, Item i2) {
                return i1.getCallNumber().compareTo(i2.getCallNumber());
            }
        });
        
        // Reshelve items
        for (Item item : unshelvedItems) {
            item.setStatus("shelved");
            //Call method to reset the status of the item
        }
        
        // Clear the list of unshelved items
        unshelvedItems.clear();
    }
    
}
