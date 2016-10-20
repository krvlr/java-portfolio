package ru.itis.factories;

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
                    new FileInputStream("C:\\Users\\KFU-user\\Desktop\\JavaWorks\\SimpleServlet\\src\\resources\\JdbcProperties.properties"));

            String driver = properties.getProperty("connection.driver");
            String connectionURL = properties.getProperty("connection.connectionURL");
            String userName = properties.getProperty("connection.userName");
            String userPassword = properties.getProperty("connection.userPassword");

            Class.forName(driver);
            connection = DriverManager.getConnection(connectionURL, userName, userPassword);
        } catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }

    public static JdbcConnection getInstance(){
        return instance;
    }

    public Connection getConnection(){
        return connection;
    }

}
