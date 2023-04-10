import java.util.List;

public class Technician extends Employee {
    
    public ArrayList sortBatch(ArrayList l){  //Sorts the items in the batch into an order ideal for the technician to easily reshelve them

    }
    public void reshelve(Item i){
        i.setLocation(Location l); //Location class probably consists of section, collection, and Dewey decimal number
        i.setStatus(1); //Sets the status of the item as "shelved"
    }
}
