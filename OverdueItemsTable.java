import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class OverdueItemsTable extends JPanel {
    private DefaultTableModel tableModel;
    JTable table = new JTable(tableModel);

    public OverdueItemsTable() {
        tableModel = new DefaultTableModel(new Object[]{"Title", "Author", "Checked Out Date", "Days Overdue"}, 0);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);
    }

    public void setOverdueItems(ArrayList<Item> list) {
        tableModel.setRowCount(0);
        for (Item i : list) {
            Object[] rowData = {i.getTitle(), i.getAuthor(), i.getCheckoutDate(), i.getDaysOverdue()};
            tableModel.addRow(rowData);
        }
    }

    public JTable getTable(){
        return this.table;
    }
}