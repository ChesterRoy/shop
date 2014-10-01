import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * Classes.User: roy
 * Date: 25.03.14
 * Time: 18:18
 * To change this template use File | Settings | File Templates.
 */
public class Table extends JTable {
    ProductDAOIml productDAOIml;
    private Vector<String> columnsNames;

    public Table(ProductDAOIml obj) {
        initTable();
        refreshTable();
    }

    public void initTable() {
        productDAOIml = new ProductDAOIml();
        columnsNames = new Vector<String>();
        columnsNames.add("Id");
        columnsNames.add("Name");
        columnsNames.add("Description");
        columnsNames.add("Quantity");
    }

    public Product getSelectedProduct() {
        Vector<Object> row = productDAOIml.getAllProducts().get(getSelectedRow());
        return new Product(
                (Integer) row.get(0),
                (String) row.get(1),
                (String) row.get(2),
                (Integer) row.get(3));
    }

    public void refreshTable() {
        MyTableModel tableModel = new MyTableModel(productDAOIml.getAllProducts(), columnsNames);
        setModel(tableModel);
    }
}
