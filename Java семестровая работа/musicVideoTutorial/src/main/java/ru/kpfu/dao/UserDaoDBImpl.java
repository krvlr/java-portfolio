package ru.kpfu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.kpfu.model.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoDBImpl implements UserDao {

    //language=SQL
    private static final String SQL_CREATE_USER = "INSERT INTO \"user\" (name, password, email, country, sex) " +
            "VALUES(:name, :password, :email, :country, :sex)";
    //language=SQL
    private static final String SQL_UPDATE_USER = "UPDATE \"user\" SET name = :name, password = :password, email = :email, country = :country, sex = :sex" +
            "WHERE user_id = :userId";
    //language=SQL
    private static final String SQL_DELETE_USER = "DELETE FROM \"user\" WHERE user_id = :userId";
    //language=SQL
    private static final String SQL_GET_ALL_USER = "SELECT * FROM \"user\"";
    //language=SQL
    private static final String SQL_FIND_USER_BY_LOGIN_AND_PASSWORD = "SELECT * FROM \"user\" WHERE name = :name AND password = :password";
    // language=SQL
    public static final String SQL_SET_USER_TOKEN = "UPDATE \"user\" SET token = :token WHERE user_id = :userId";
    // language=SQL
    public static final String SQL_FIND_USER_BY_TOKEN = "SELECT * FROM \"user\" WHERE token = :token";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public UserDaoDBImpl(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void create(User user) {
        Map createParams = new HashMap<>();
        createParams.put("name", user.getName());
        createParams.put("password", user.getPassword());
        createParams.put("email", user.getEmail());
        createParams.put("country", user.getCountry());
        createParams.put("sex", user.getSex());
        namedParameterJdbcTemplate.update(SQL_CREATE_USER, createParams);
    }

    @Override
    public void update(User user) {
        Map updateParams = new HashMap<>();
        updateParams.put("name", user.getName());
        updateParams.put("password", user.getPassword());
        updateParams.put("email", user.getEmail());
        updateParams.put("country", user.getCountry());
        updateParams.put("sex", user.getSex());
        updateParams.put("userId", user.getUserId());
        namedParameterJdbcTemplate.update(SQL_UPDATE_USER, updateParams);
    }

    @Override
    public void delete(int userId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("userId", userId);
        namedParameterJdbcTemplate.update(SQL_DELETE_USER, sqlParameterSource);
    }

    @Override
    public List<User> getAll() {
        return namedParameterJdbcTemplate.query(SQL_GET_ALL_USER, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet result, int rowNum) throws SQLException {
                return new User(result.getInt("user_id"), result.getString("name"),
                        result.getString("password"), result.getString("email"), result.getString("country"),
                        result.getString("sex"), result.getString("token"));
            }
        });
    }

    /*@Override
    public User findByNameAndPassword(String userName, String password) {
        Map findParams = new HashMap<>();
        findParams.put("name", userName);
        findParams.put("password", password);
        return (User) namedParameterJdbcTemplate.query(SQL_FIND_USER_BY_LOGIN_AND_PASSWORD, findParams, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet result, int rowNum) throws SQLException {
                return new User(result.getInt("user_id"), result.getString("name"),
                        result.getString("password"), result.getString("email"), result.getString("country"),
                        result.getString("sex"), result.getString("token"));
            }
        }).get(0);
    }*/

    @Override
    public User findByNameAndPassword(String userName, String password) {
        Map findParams = new HashMap<>();
        findParams.put("name", userName);
        findParams.put("password", password);
        List<User> findUsers = namedParameterJdbcTemplate.query(SQL_FIND_USER_BY_LOGIN_AND_PASSWORD, findParams, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet result, int rowNum) throws SQLException {
                return new User(result.getInt("user_id"), result.getString("name"),
                        result.getString("password"), result.getString("email"), result.getString("country"),
                        result.getString("sex"), result.getString("token"));
            }
        });
        System.out.println(findUsers.get(0));
        if (findUsers != null) {
            return findUsers.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void setToken(int idUser, String newToken) {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("userId", idUser);
        paramsMap.put("token", newToken);
        this.namedParameterJdbcTemplate.update(SQL_SET_USER_TOKEN, paramsMap);
    }

    @Override
    public User findByToken(String token) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("token", token);
        return namedParameterJdbcTemplate.query(SQL_FIND_USER_BY_TOKEN, sqlParameterSource, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet result, int rowNum) throws SQLException {
                return new User(result.getInt("user_id"), result.getString("name"),
                        result.getString("password"), result.getString("email"), result.getString("country"),
                        result.getString("sex"), result.getString("token"));
            }
        }).get(0);
    }
}