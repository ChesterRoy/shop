import java.sql.*;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * Classes.User: roy
 * Date: 20.03.14
 * Time: 11:36
 * To change this template use File | Settings | File Templates.
 */

public class ProductDAOIml implements ProductDAO {

    public Vector<Vector> getAllProducts() {
        Vector<Vector> allProduct = new Vector<Vector>();
        Connection connection = JDBConnection.getInstance().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_QUERY);
            for(int i = 0; resultSet.next(); i++){
                allProduct.add(new Vector<Object>(4));
                allProduct.get(i).add(resultSet.getInt("id"));
                allProduct.get(i).add(resultSet.getString("name"));
                allProduct.get(i).add(resultSet.getString("description"));
                allProduct.get(i).add(resultSet.getInt("quantity"));
            }
            resultSet.close();
        } catch (SQLException e) {4
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    statement.close();
                    connection.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return allProduct;
    }

    public boolean addProduct(Product obj) {
        Connection connection = JDBConnection.getInstance().getConnection();
        PreparedStatement statement = null;
        boolean flag = false;
        try {
            statement = connection.prepareStatement(INSERT_QUERY);
            statement.setString(1, obj.getName());
            statement.setString(2, obj.getDescription());
            statement.setInt(3, obj.getQuantity());
            flag = statement.execute();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    statement.close();
                    connection.close();
                }
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }
        return flag;
    }

    public boolean updateProduct(Product obj) {
        Connection connection = JDBConnection.getInstance().getConnection();
        PreparedStatement statement = null;
        boolean flag = false;
        try {
            statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, obj.getName());
            statement.setString(2, obj.getDescription());
            statement.setInt(3, obj.getQuantity());
            statement.setInt(4, obj.getId());
            flag = statement.execute();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    statement.close();
                    connection.close();
                }
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }
        return flag;
    }

    public boolean deleteProduct(Product obj) {
        Connection connection = JDBConnection.getInstance().getConnection();
        PreparedStatement statement = null;
        boolean flag = false;
        try {
            statement = connection.prepareStatement(DELETE_QUERY);
            statement.setInt(1, obj.getId());
            flag = statement.execute();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    statement.close();
                    connection.close();
                }
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }
        return flag;
    }
}
