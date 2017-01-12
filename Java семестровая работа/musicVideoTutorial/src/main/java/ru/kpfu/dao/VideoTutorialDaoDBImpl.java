package ru.kpfu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.kpfu.model.VideoTutorial;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class VideoTutorialDaoDBImpl implements VideoTutorialDao {

    //language=SQL
    private static final String SQL_INSERT_VIDEO_TUTORIAL = "INSERT INTO video_tutorial (owner_id, description) " +
            "VALUES (:ownerId, :description)";
    //language=SQL
    private static final String SQL_UPDATE_VIDEO_TUTORIAL = "UPDATE video_tutorial " +
            "SET description = :description WHERE video_tutorial_id = :videoTutorialId";
    //language=SQL
    private static final String SQL_DELETE_VIDEO_TUTORIAL = "DELETE FROM video_tutorial" +
            "WHERE video_tutorial_id = :videoTutorialId";
    //language=SQL
    private static final String SQL_GET_ALL_VIDEO_TUTORIAL = "SELECT * FROM video_tutorial";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public VideoTutorialDaoDBImpl(DataSource dataSource){
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void create(VideoTutorial videoTutorial) {
        Map createParams = new HashMap<>();
        createParams.put("ownerId", videoTutorial.getOwnerId());
        createParams.put("description", videoTutorial.getDescription());
        namedParameterJdbcTemplate.update(SQL_INSERT_VIDEO_TUTORIAL, createParams);
    }

    @Override
    public void update(VideoTutorial videoTutorial) {
        Map updateParams = new HashMap<>();
        updateParams.put("ownerId", videoTutorial.getOwnerId());
        updateParams.put("description", videoTutorial.getDescription());
        updateParams.put("videoTutorialId", videoTutorial.getVideoTutorialId());
        namedParameterJdbcTemplate.update(SQL_UPDATE_VIDEO_TUTORIAL, updateParams);
    }

    @Override
    public void delete(int videoTutorialId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("videoTutorialId", videoTutorialId);
        namedParameterJdbcTemplate.update(SQL_DELETE_VIDEO_TUTORIAL, sqlParameterSource);
    }

    @Override
    public List<VideoTutorial> getAll() {
        return namedParameterJdbcTemplate.query(SQL_GET_ALL_VIDEO_TUTORIAL, new RowMapper<VideoTutorial>() {
            @Override
            public VideoTutorial mapRow(ResultSet result, int rowNum) throws SQLException {
                return new VideoTutorial(result.getInt("video_tutorial_id"),
                        result.getInt("owner_id"), result.getString("description"));
            }
        });
    }
}
