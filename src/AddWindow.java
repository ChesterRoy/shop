import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * Classes.User: roy
 * Date: 26.03.14
 * Time: 17:54
 * To change this template use File | Settings | File Templates.
 */
public class AddWindow extends JFrame {
    public JButton yesButton;
    public JButton cancelButton;
    private JLabel name;
    private JLabel description;
    private JLabel quantity;
    public JTextField nameTextField;
    public JTextField descriptionTextField;
    public JTextField quantityTextField;
    private JPanel panel;

    public AddWindow() {
        initComponents();
    }

    private void initComponents() {

        yesButton = new JButton("Ok");
        cancelButton = new JButton("Cancel");
        name = new JLabel("Name");
        description = new JLabel("Description");
        quantity = new JLabel("Quantity");
        nameTextField = new JTextField(15);
        descriptionTextField = new JTextField(15);
        quantityTextField = new JTextField(15);
        panel = new JPanel();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(280, 170);
        setResizable(false);
        getContentPane();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (screenSize.width - getWidth()) / 2;
        int locationY = (screenSize.height - getHeight()) / 2;
        setBounds(locationX, locationY, getWidth(), getHeight());

        panel.setLayout(null);

        name.setBounds(10, 10, 80, 25);
        panel.add(name);

        nameTextField.setBounds(100, 10, 160, 25);
        panel.add(nameTextField);

        description.setBounds(10, 40, 80, 25);
        panel.add(description);

        descriptionTextField.setBounds(100, 40, 160, 25);
        panel.add(descriptionTextField);

        quantity.setBounds(10, 70, 80, 25);
        panel.add(quantity);

        quantityTextField.setBounds(100, 70, 160, 25);
        panel.add(quantityTextField);

        yesButton.setBounds(50, 110, 80, 25);
        panel.add(yesButton);

        cancelButton.setBounds(140, 110, 80, 25);
        panel.add(cancelButton);

        add(panel);

    }
}
