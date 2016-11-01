package dao;

import models.Car;
import models.CarUser;
import models.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarsAndUsersDaoImpl implements CarsAndUsersDao {
    // language=SQL
    public static final String SQL_GET_ALL_ID = "SELECT * FROM cars_users;";
    // language=SQL
    public static final String SQL_ADD_CAR_USER = "INSERT INTO cars_users(id_car, id_user) VALUES (:idCar, :idUser);";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CarsAndUsersDaoImpl(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<CarUser> getAll() {
        return this.namedParameterJdbcTemplate.query(
                SQL_GET_ALL_ID,
                new RowMapper<CarUser>() {
                    @Override
                    public CarUser mapRow(ResultSet result, int rowNum) throws SQLException {
                        return new CarUser(result.getInt("id_car"), result.getInt("id_user"));
                    }
                });
    }

    @Override
    public void addCarUser(Car car, User user) {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("idCar", car.getId());
        paramsMap.put("idUser", user.getId());
        this.namedParameterJdbcTemplate.update(
                SQL_ADD_CAR_USER, paramsMap
        );
    }
}
