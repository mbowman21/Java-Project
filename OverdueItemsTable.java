import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class OverdueItemsTable extends JPanel {
    private DefaultTableModel tableModel;
    private JTable table;

    public void OverdueBooksTable() {
        this.tableModel = new DefaultTableModel(new Object[]{"Title", "Author", "Checked Out Date", "Days Overdue"}, 0);
        this.table = new JTable(tableModel);
    }

    public void setOverdueItems(ArrayList<Item> list) {
        tableModel.setRowCount(0);
        for (Item i : list) {
            Integer daysOverdue = i.getDaysOverdue();
            Object[] rowData = {i.getTitle(), i.getAuthor(), i.getCheckoutDate(), i.getDaysOverdue()};
            tableModel.addRow(rowData);
        }
    }

    public JTable getTable(){
        return this.table;
    }
}