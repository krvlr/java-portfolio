package ru.itis.utils;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Message;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageMapper implements RowMapper {
    @Override
    public Message mapRow(ResultSet result, int rowNum) throws SQLException {
        return new Message(result.getInt("message_id"), result.getString("text"),
                result.getInt("chat_id"), result.getInt("user_id"));
    }
}
