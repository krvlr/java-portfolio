package ru.itis.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.itis.models.Message;
import ru.itis.utils.MessageMapper;

import javax.sql.DataSource;
import java.util.*;

@Repository
public class MessageDaoImpl implements MessageDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //language=SQL
    private static final String SQL_GET_ALL_MESSAGES = "SELECT * FROM message";
    //language=SQL
    private static final String SQL_FIND_MESSAGES = "SELECT * FROM message WHERE message_id = :messageId";
    //language=SQL
    private static final String SQL_FIND_MASSAGE_BY_CHAT_ID = "SELECT * FROM message JOIN chat ON message.chat_id = chat.chat_id WHERE chat.chat_id = :chatId";
    //language=SQL
    private static final String SQL_ADD_MESSAGE = "INSERT INTO message(text, chat_id, user_id) VALUES (:text, :chatId, :userId)";
    //language=SQL
    private static final String SQL_UPDATE_MESSAGE = "UPDATE message SET text = :text WHERE message_id = :messageId";

    public MessageDaoImpl(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Message> getAll() {
        return namedParameterJdbcTemplate.query(SQL_GET_ALL_MESSAGES, new MessageMapper());
    }

    @Override
    public Message findById(Integer messageId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("messageId", messageId);
        return (Message) namedParameterJdbcTemplate.queryForObject(SQL_FIND_MESSAGES, sqlParameterSource, new MessageMapper());
    }

    @Override
    public List<Message> findByChatId(Integer chatId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("chatId", chatId);
        return namedParameterJdbcTemplate.query(SQL_FIND_MASSAGE_BY_CHAT_ID, sqlParameterSource, new MessageMapper());
    }

    @Override
    public void add(Message message) {
        Map params = new HashMap<>();
        params.put("text", message.getText());
        params.put("chatId", message.getChatId());
        params.put("userId", message.getUserId());
        namedParameterJdbcTemplate.update(SQL_ADD_MESSAGE, params);
    }

    @Override
    public void update(Message message) {
        Map params = new HashMap<>();
        params.put("messageId", message.getMessageId());
        params.put("text", message.getText());
        namedParameterJdbcTemplate.update(SQL_UPDATE_MESSAGE, params);
    }
}
