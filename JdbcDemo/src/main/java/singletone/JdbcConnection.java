package singletone;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JdbcConnection {

    public static JdbcConnection instance;

    private Properties properties;

    private Connection connection;

    static {
        instance = new JdbcConnection();
    }

    private JdbcConnection(){

        properties = new Properties();
        try {
            properties.load(
                    new FileInputStream("C:\\Users\\nanob\\Desktop\\JavaWorks\\JdbcDemo\\src\\main\\resources\\JdbcProperties.properties"));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        String connectionURL = properties.getProperty("connection.connectionURL");
        String userName = properties.getProperty("connection.userName");
        String userPassword = properties.getProperty("connection.userPassword");

        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connectionURL, userName, userPassword);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static JdbcConnection getInstance(){
        return instance;
    }

    public Connection getConnection(){
        return connection;
    }

}
