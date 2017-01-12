package ru.itis.utils;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper {
    @Override
    public User mapRow(ResultSet result, int rowNum) throws SQLException {
        return new User(result.getInt("user_id"), result.getString("name"), result.getString("name"), result.getString("hash_password"));
    }
}