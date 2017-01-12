package ru.kpfu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.kpfu.model.Comment;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CommentDaoDBImpl implements CommentDao {

    //language=SQL
    private static final String SQL_INSERT_COMMENT = "INSERT INTO comment(user_id, video_tutorial_id, comment) " +
            "VALUES (userId, :videoTutorialId, :comment)";
    //language=SQL
    private static final String SQL_UPDATE_COMMENT = "UPDATE comment SET comment = :comment" +
            "WHERE comment_id = :commentId";
    //language=SQL
    private static final String SQL_DELETE_COMMENT = "DELETE FROM comment WHERE comment_id = commentId";
    //language=SQL
    private static final String SQL_FIND_COMMENT = "SELECT * FROM comment WHERE user_id = :userId AND video_tutorial_di = :videoTutorialId";
    //language=SQL
    private static final String SQL_GET_ALL_COMMENT = "SELECT * FROM comment";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public CommentDaoDBImpl(DataSource dataSource){
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void create(Comment comment) {
        Map createParams = new HashMap<>();
        createParams.put("userId", comment.getUserId());
        createParams.put("videoTutorialId", comment.getVideoTutorialId());
        createParams.put("comment", comment.getComment());
        namedParameterJdbcTemplate.update(SQL_INSERT_COMMENT, createParams);
    }

    @Override
    public void update(Comment comment) {
        Map updateParams = new HashMap<>();
        updateParams.put("userId", comment.getUserId());
        updateParams.put("videoTutorialId", comment.getVideoTutorialId());
        updateParams.put("comment", comment.getComment());
        updateParams.put("commentId", comment.getCommentId());
        namedParameterJdbcTemplate.update(SQL_UPDATE_COMMENT, updateParams);
    }

    @Override
    public void delete(int commentId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("commentId", commentId);
        namedParameterJdbcTemplate.update(SQL_DELETE_COMMENT, sqlParameterSource);
    }

    @Override
    public Comment find(int userId, int videoTutorialId) {
        Map createParams = new HashMap<>();
        createParams.put("userId", userId);
        createParams.put("videoTutorialId", videoTutorialId);
        return namedParameterJdbcTemplate.query(SQL_FIND_COMMENT, new RowMapper<Comment>() {
            @Override
            public Comment mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Comment(resultSet.getInt("comment_id"), resultSet.getInt("user_id"),
                        resultSet.getInt("video_tutorial_id"), resultSet.getString("comment"));
            }
        }).get(0);
    }

    @Override
    public List<Comment> getAll() {
        return namedParameterJdbcTemplate.query(SQL_GET_ALL_COMMENT, new RowMapper<Comment>() {
            @Override
            public Comment mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Comment(resultSet.getInt("comment_id"), resultSet.getInt("user_id"),
                        resultSet.getInt("video_tutorial_id"), resultSet.getString("comment"));
            }
        });
    }
}
