package ru.itis.utils;

import ru.itis.factories.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Verifier {
    private static Connection connection;

    static {
        connection = JdbcConnection.getInstance().getConnection();
    }

    // language=SQL
    private static final String SQL_FIND_OWNER = "SELECT * FROM owners WHERE owner_id = ?;";

    public static void verifyUserExist(int userId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_OWNER);
            preparedStatement.setInt(1, userId);

            ResultSet result = preparedStatement.executeQuery();

            if (!result.next()) {
                throw new IllegalArgumentException("USER_NOT_FOUND");
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
