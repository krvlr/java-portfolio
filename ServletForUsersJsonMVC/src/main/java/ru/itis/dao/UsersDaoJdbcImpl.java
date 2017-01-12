package ru.itis.dao;

import ru.itis.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UsersDaoJdbcImpl implements UsersDao {
    // language=SQL
    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM users;";
    // language=SQL
    public static final String SQL_ADD_USERS = "INSERT INTO users(first_name, last_name, date_of_birth, city, login, password) VALUES (:firstName, :lastName, :dateOfBirth::date, :city, :login, :password);";
    // language=SQL
    public static final String SQL_UPDATE_USERS = "UPDATE users SET first_name = :firstName, last_name = :lastName, date_of_birth::date = :dateOfBirth, city = :city, login = :login, password = :password WHERE id_user = :idUser ;";
    // language=SQL
    public static final String SQL_DELETE_USERS = "DELETE FROM users WHERE id_user = :idUser;";
    // language=SQL
    public static final String SQL_GET_TOKEN = "SELECT token FROM users WHERE id_user = :idUser;";
    // language=SQL
    public static final String SQL_SET_TOKEN = "UPDATE users SET token = :token WHERE id_user = :idUser;";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public UsersDaoJdbcImpl(DataSource dataSource){
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<User> getAll() {
        return this.namedParameterJdbcTemplate.query(
                SQL_SELECT_ALL_USERS,
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet result, int rowNum) throws SQLException {
                        return new User(result.getInt("id_user"), result.getString("first_name"), result.getString("last_name"), result.getDate("date_of_birth"), result.getString("city"), result.getString("login"), result.getString("password"), result.getString("token"));
                    }
                });
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
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("firstName", user.getFirstName());
        paramsMap.put("lastName", user.getLastName());
        paramsMap.put("dateOfBirth", new SimpleDateFormat("yyyy-MM-dd").format((user.getDateOfBirth())));
        paramsMap.put("city", user.getCity());
        paramsMap.put("login", user.getLogin());
        paramsMap.put("password", user.getPassword());
        this.namedParameterJdbcTemplate.update(
                SQL_ADD_USERS, paramsMap
        );
    }

    @Override
    public void update(User user) {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("firstName", user.getFirstName());
        paramsMap.put("lastName", user.getLastName());
        paramsMap.put("dateOfBirth", new SimpleDateFormat("yyyy-MM-dd").format((user.getDateOfBirth())));
        paramsMap.put("city", user.getCity());
        paramsMap.put("login", user.getLogin());
        paramsMap.put("password", user.getPassword());
        paramsMap.put("idUser", user.getId());
        this.namedParameterJdbcTemplate.update(
                SQL_UPDATE_USERS, paramsMap
        );
    }

    @Override
    public void delete(int id) {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("idUser", id);
        this.namedParameterJdbcTemplate.update(
                SQL_DELETE_USERS, paramsMap
        );
    }

    @Override
    public String getToken(User user) {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("idUser", user.getId());
        List<String> token = this.namedParameterJdbcTemplate.query(
                SQL_GET_TOKEN, paramsMap,
                new RowMapper<String>(){
                    @Override
                    public String mapRow(ResultSet result, int rowNum) throws SQLException {
                        return result.getString("token");
                    }
                });
        return token.get(0);
    }

    @Override
    public void setToken(User user) {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("token", user.getToken());
        paramsMap.put("idUser", user.getId());
        this.namedParameterJdbcTemplate.update(
                SQL_SET_TOKEN, paramsMap
        );
    }
}
