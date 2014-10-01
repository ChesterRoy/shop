/**
 * Created with IntelliJ IDEA.
 * Classes.User: roy
 * Date: 20.03.14
 * Time: 11:35
 * To change this template use File | Settings | File Templates.
 */

import java.util.List;
import java.util.Vector;

public interface ProductDAO {
    final String GET_ALL_QUERY = "SELECT id, name, description, quantity FROM product ORDER BY id";
    final String INSERT_QUERY = "INSERT INTO product(name, description, quantity) VALUES (?, ?, ?)";
    final String UPDATE_QUERY = "UPDATE product SET name = ?, description = ?, quantity = ? WHERE id = ?";
    final String DELETE_QUERY = "DELETE FROM product WHERE id = ?";

    public Vector<Vector> getAllProducts();

    public boolean addProduct(Product obj);

    public boolean updateProduct(Product obj);

    public boolean deleteProduct(Product obj);

}


