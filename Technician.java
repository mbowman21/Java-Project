import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.time.LocalDate;

public class Technician extends Employee {
    private List<Item> unshelvedItems;
    private String u="unshelved";//Stores the string object we will compare the status of the book to

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
