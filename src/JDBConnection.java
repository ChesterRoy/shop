import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBConnection {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/internet_shop";
    static final String USER = "root";
    static final String PASSWORD = "root";

    private static JDBConnection instance = new JDBConnection();

    private JDBConnection() {

        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException exc) {
            System.out.println("Error: unable to load driver class!");
            exc.printStackTrace();
        }
    }

    public Connection getConnection(){
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(
                    DB_URL,
                    USER,
                    PASSWORD);

        } catch (SQLException sqlException) {
            System.out.println("Connection Failed!");
            sqlException.printStackTrace();
        }
        return connection;
    }

    public static JDBConnection getInstance() {
          return instance;
    }
}
