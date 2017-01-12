package ru.itis.utils;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Chat;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChatMapper implements RowMapper {
    @Override
    public Chat mapRow(ResultSet result, int rowNum) throws SQLException {
        return new Chat(result.getInt("chat_id"), result.getString("name"), result.getInt("owner_id"));
    }
}
