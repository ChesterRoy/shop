import javax.swing.table.DefaultTableModel;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * Classes.User: roy
 * Date: 28.03.14
 * Time: 10:25
 * To change this template use File | Settings | File Templates.
 */
public class MyTableModel extends DefaultTableModel {

    public MyTableModel(Vector data, Vector columnNames) {
        super(data, columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

}
