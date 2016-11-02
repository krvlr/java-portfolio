package dao;

import models.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoJdbcImpl implements UsersDao {
    // language=SQL
    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM users;";
    // language=SQL
    public static final String SQL_ADD_USERS = "INSERT INTO users(first_name, last_name, date_of_birth, city, login, password) VALUES (?, ?, ?::date, ?, ?, ?);";
    // language=SQL
    public static final String SQL_UPDATE_USERS = "UPDATE users SET first_name = ?, last_name = ?, date_of_birth::date = ?, city = ?, login = ?, password = ? WHERE id_user = ? ;";
    // language=SQL
    public static final String SQL_DELETE_USERS = "DELETE FROM users WHERE id_user = ?;";
    // language=SQL
    public static final String SQL_GET_TOKEN = "SELECT token FROM users WHERE id_user = ?;";
    // language=SQL
    public static final String SQL_SET_TOKEN = "UPDATE users SET token = ? WHERE id_user = ?;";

    private Connection connection;
    private Statement statement;

    public UsersDaoJdbcImpl(Connection connection){
        try{
            this.connection = connection;
            statement = connection.createStatement();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> getAll() {
        List<User> allUsers = new ArrayList<User>();
        try{
            ResultSet result = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while(result.next()) {
                allUsers.add(new User(result.getInt("id_user"), result.getString("first_name"), result.getString("last_name"), result.getDate("date_of_birth"), result.getString("city"), result.getString("login"), result.getString("password"), result.getString("token")));
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return allUsers;
    }

    @Override
    public User find(int id) {
        for(User user : getAll()){
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

    @Override
    public void add(User user) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_USERS);

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, new SimpleDateFormat("yyyy-MM-dd").format((user.getDateOfBirth())));
            preparedStatement.setString(4, user.getCity());
            preparedStatement.setString(5, user.getLogin());
            preparedStatement.setString(6, user.getPassword());

            preparedStatement.execute();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void update(User user) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_USERS);

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, new SimpleDateFormat("yyyy-MM-dd").format((user.getDateOfBirth())));
            preparedStatement.setString(4, user.getCity());
            preparedStatement.setString(5, user.getLogin());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.setInt(7, user.getId());

            preparedStatement.execute();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_USERS);

            preparedStatement.setInt(1, id);

            preparedStatement.execute();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getToken(User user) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_TOKEN);
            preparedStatement.setInt(1, user.getId());
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            return result.getString("token");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void setToken(User user) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SET_TOKEN);
            preparedStatement.setString(1, user.getToken());
            preparedStatement.setInt(2, user.getId());
            preparedStatement.execute();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
