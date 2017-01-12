package ru.itis.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.itis.models.User;
import ru.itis.utils.UserMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //language=SQL
    private static final String SQL_GET_ALL_USER = "SELECT * FROM chat_user";
    //language=SQL
    private static final String SQL_FIND_USER = "SELECT * FROM chat_user WHERE user_id = :userId";
    //language=SQL
    private static final String SQL_ADD_USER = "INSERT INTO chat_user(name, hash_password, login) VALUES (:name, :hashPassword, :login)";
    //language=SQL
    private static final String SQL_DELETE_USER = "DELETE FROM chat_user WHERE user_id = :userId";
    //language=SQL
    private static final String SQL_UPDATE_USER = "UPDATE chat_user SET name = :name, hash_password = :hashPassword, login = :login WHERE user_id = :userId";

    //language=SQL
    private static final String SQL_GET_TOKEN = "SELECT user_token.token FROM user_token WHERE user_token.user_id = :userId";
    //language=SQL
    private static final String SQL_ADD_TOKEN = "INSERT INTO user_token(user_id, token) VALUES(:userId, :token)";
    //language=SQL
    private static final String SQL_UPDATE_TOKEN = "UPDATE user_token SET token = :token WHERE user_id = :userId";

    //language=SQL
    private static final String SQL_ADD_USER_FEAT_CHAT = "INSERT INTO user_feat_chat(chat_id, user_id) VALUES (:chatId, :userId)";
    //language=SQL
    private static final String SQL_DELETE_USER_FEAT_CHAT = "DELETE FROM user_feat_chat WHERE chat_id = :chatId, user_id = userId";

    //language=SQL
    private static final String SQL_SET_LAST_USER_MESSAGE = "INSERT INTO user_message(user_id, chat_id, last_message_id) VALUES (:userId, :chatId, :lastMessageId)";
    //language=SQL
    private static final String SQL_UPDATE_LAST_USER_MESSAGE = "UPDATE user_message SET last_message_id = :lastMessageId " +
            "WHERE user_id = :userId AND chat_id = :chatId";

    public UserDaoImpl(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<User> getAll() {
        return namedParameterJdbcTemplate.query(SQL_GET_ALL_USER, new UserMapper());
    }

    @Override
    public User findById(Integer userId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("userId", userId);
        return (User) namedParameterJdbcTemplate.queryForObject(SQL_FIND_USER, sqlParameterSource, new UserMapper());
    }

    @Override
    public User findByLogin(String login) {
        return null;
    }

    @Override
    public void add(User user) {
        Map params = new HashMap<>();
        params.put("name", user.getName());
        params.put("hashPassword", user.getHashPassword());
        params.put("login", user.getLogin());
        namedParameterJdbcTemplate.update(SQL_ADD_USER, params);
    }

    @Override
    public void delete(Integer userId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("userId", userId);
        namedParameterJdbcTemplate.update(SQL_DELETE_USER, sqlParameterSource);
    }

    @Override
    public void update(User user) {
        Map params = new HashMap<>();
        params.put("name", user.getName());
        params.put("hashPassword", user.getHashPassword());
        params.put("login", user.getLogin());
        namedParameterJdbcTemplate.update(SQL_UPDATE_USER, params);
    }

    @Override
    public String getToken(Integer userId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("userId", userId);
        List<String> token = this.namedParameterJdbcTemplate.query(SQL_GET_TOKEN, sqlParameterSource, new RowMapper<String>(){
            @Override
            public String mapRow(ResultSet result, int rowNum) throws SQLException {
                return result.getString("token");
            }
        });
        return token.get(0);
    }

    @Override
    public void addToken(Integer userId, String token) {
        Map params = new HashMap<>();
        params.put("userId", userId);
        params.put("token", token);
        namedParameterJdbcTemplate.update(SQL_ADD_TOKEN, params);
    }

    @Override
    public void updateToken(Integer userId, String token) {
        Map params = new HashMap<>();
        params.put("userId", userId);
        params.put("token", token);
        namedParameterJdbcTemplate.update(SQL_UPDATE_TOKEN, params);
    }

    @Override
    public void addUserToChat(Integer userId, Integer chatId) {
        Map params = new HashMap<>();
        params.put("userId", userId);
        params.put("chatId", chatId);
        namedParameterJdbcTemplate.update(SQL_ADD_USER_FEAT_CHAT, params);
    }

    @Override
    public void deleteUserFromChat(Integer userId, Integer chatId) {
        Map params = new HashMap<>();
        params.put("userId", userId);
        params.put("chatId", chatId);
        namedParameterJdbcTemplate.update(SQL_DELETE_USER_FEAT_CHAT, params);
    }

    @Override
    public void setLastUserMessageId(Integer userId, Integer chatId, Integer lastMessageId) {
        Map params = new HashMap<>();
        params.put("userId", userId);
        params.put("chatId", chatId);
        params.put("lastMessageId", lastMessageId);
        namedParameterJdbcTemplate.update(SQL_SET_LAST_USER_MESSAGE, params);
    }

    @Override
    public void updateLastUserMessageId(Integer userId, Integer chatId, Integer lastMessageId) {
        Map params = new HashMap<>();
        params.put("userId", userId);
        params.put("chatId", chatId);
        params.put("lastMessageId", lastMessageId);
        namedParameterJdbcTemplate.update(SQL_UPDATE_LAST_USER_MESSAGE, params);
    }
}
