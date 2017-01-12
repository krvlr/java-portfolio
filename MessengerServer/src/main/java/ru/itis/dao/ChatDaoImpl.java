package ru.itis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.itis.models.Chat;
import ru.itis.utils.ChatMapper;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ChatDaoImpl implements ChatDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //language=SQL
    private static final String SQL_GET_ALL_CHAT = "SELECT * FROM chat";
    //language=SQL
    private static final String SQL_FIND_CHAT = "SELECT * FROM chat WHERE chat_id = :chatId";
    //language=SQL
    private static final String SQL_ADD_CHAT = "INSERT INTO chat(name, owner_id) VALUES (:name, :ownerId)";
    //language=SQL
    private static final String SQL_DELETE_CHAT = "DELETE FROM chat WHERE chat_id = :chatId";
    //language=SQL
    private static final String SQL_UPDATE_CHAT = "UPDATE chat SET name = :name, owner_id = :ownerId WHERE chat_id = :chatId";

    @Autowired
    public ChatDaoImpl(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Chat> getAll() {
        return namedParameterJdbcTemplate.query(SQL_GET_ALL_CHAT, new ChatMapper());
    }

    @Override
    public Chat find(Integer chatId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("chatId", chatId);
        return (Chat) namedParameterJdbcTemplate.queryForObject(SQL_FIND_CHAT, sqlParameterSource, new ChatMapper());
    }

    @Override
    public void add(Chat chat) {
        Map params = new HashMap<>();
        params.put("name", chat.getName());
        params.put("ownerId", chat.getOwnerId());
        namedParameterJdbcTemplate.update(SQL_ADD_CHAT, params);
    }

    @Override
    public void delete(Integer chatId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("chatId", chatId);
        namedParameterJdbcTemplate.update(SQL_DELETE_CHAT, sqlParameterSource);
    }

    @Override
    public void update(Chat chat) {
        Map params = new HashMap<>();
        params.put("name", chat.getName());
        params.put("ownerId", chat.getOwnerId());
        namedParameterJdbcTemplate.update(SQL_UPDATE_CHAT, params);
    }
}
