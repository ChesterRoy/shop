import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created with IntelliJ IDEA.
 * Classes.User: roy
 * Date: 25.03.14
 * Time: 17:44
 * To change this template use File | Settings | File Templates.
 */

public class MainFrame extends JFrame {

    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JScrollPane scrollPane;
    private JLabel label;
    private Table table;
    private JPanel panel;
    private Box box;
    ProductDAOIml productDAOIml;

    public MainFrame() {
        initComponents();
    }

    public void initComponents() {
        productDAOIml = new ProductDAOIml();
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        scrollPane = new JScrollPane();
        label = new JLabel("Count: " + productDAOIml.getAllProducts().size());
        table = new Table(productDAOIml);
        panel = new JPanel();
        box = Box.createHorizontalBox();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 500);
        setTitle("Internet shop");
        setResizable(false);
        getContentPane();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (screenSize.width - getWidth()) / 2;
        int locationY = (screenSize.height - getHeight()) / 2;
        setBounds(locationX, locationY, getWidth(), getHeight());

        scrollPane.setViewportView(table);

        BorderLayout layout = new BorderLayout();
        panel.setLayout(layout);
        panel.add(label, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        box.add(addButton);
        box.add(editButton);
        box.add(deleteButton);
        panel.add(box, BorderLayout.SOUTH);
        this.add(panel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddActionPerformed(e);
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditActionPerformed(e);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DelActionPerformed(e);
            }
        });
    }

    private void AddActionPerformed(ActionEvent evt) {

        addButton.setEnabled(false);
        final AddWindow window = new AddWindow();
        window.setTitle("Add product");
        window.yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productDAOIml.addProduct(new Product(0, window.nameTextField.getText(), window.descriptionTextField.getText(), Integer.parseInt(window.quantityTextField.getText())));
                table.refreshTable();
                window.setVisible(false);
                addButton.setEnabled(true);

                productDAOIml.getAllProducts().trimToSize();
                label.setText("Count: " + productDAOIml.getAllProducts().size());
            }
        });

        window.cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.setVisible(false);
                addButton.setEnabled(true);
            }
        });

        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                addButton.setEnabled(true);
            }
        });
    }

    private void EditActionPerformed(ActionEvent evt) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Select row before edit!");
        } else {
            editButton.setEnabled(false);
            final AddWindow window = new AddWindow();
            window.setTitle("Edit product");
            final Product selectedProduct = table.getSelectedProduct();
            window.nameTextField.setText(selectedProduct.getName());
            window.descriptionTextField.setText(selectedProduct.getDescription());
            window.quantityTextField.setText(((Integer) selectedProduct.getQuantity()).toString());
            window.yesButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    productDAOIml.updateProduct(new Product(selectedProduct.getId(), window.nameTextField.getText(), window.descriptionTextField.getText(), Integer.parseInt(window.quantityTextField.getText())));
                    table.refreshTable();
                    window.setVisible(false);
                    editButton.setEnabled(true);
                }
            });

            window.cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    window.setVisible(false);
                    editButton.setEnabled(true);
                }
            });

            window.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    editButton.setEnabled(true);
                }
            });

        }
    }

    private void DelActionPerformed(ActionEvent evt) {
        int[] selectedRow = table.getSelectedRows();

        if (selectedRow.length <= 0) {
            JOptionPane.showMessageDialog(this, "Select row before delete!");
        } else {
            int result = JOptionPane.showConfirmDialog(this, "Are you sure?", "Message", JOptionPane.YES_NO_OPTION);
            if (result == 0) {
                Product selectedProduct = table.getSelectedProduct();
                productDAOIml.deleteProduct(selectedProduct);
            }
            productDAOIml.getAllProducts().trimToSize();
            label.setText("Count: " + productDAOIml.getAllProducts().size());
            table.refreshTable();
        }
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
