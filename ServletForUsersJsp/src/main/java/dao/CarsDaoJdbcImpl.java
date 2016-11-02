package dao;

import models.Car;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarsDaoJdbcImpl implements CarsDao {
    // language=SQL
    public static final String SQL_SELECT_ALL_CARS = "SELECT * FROM cars;";
    // language=SQL
    public static final String SQL_ADD_CAR = "INSERT INTO cars(brand, model, mileage, colour) VALUES (:brand, :model, :mileage, :colour);";
    // language=SQL
    public static final String SQL_UPDATE_CAR = "UPDATE cars SET brand = :brand, model = :model, mileage = :mileage, colour = :colour WHERE id_car = :idCar;";
    // language=SQL
    public static final String SQL_DELETE_CAR = "DELETE FROM cars WHERE id_car = :idCar;";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CarsDaoJdbcImpl(DataSource dataSource){
        //this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Car> getAll() {
        return this.namedParameterJdbcTemplate.query(
                SQL_SELECT_ALL_CARS,
                new RowMapper<Car>() {
                    @Override
                    public Car mapRow(ResultSet result, int rowNum) throws SQLException {
                        return new Car(result.getInt("id_car"), result.getString("brand"), result.getString("model"), result.getInt("mileage"), result.getString("colour"));
                    }
                });
    }

    @Override
    public Car find(int id) {
        for(Car car : getAll()){
            if (car.getId() == id){
                return car;
            }
        }
        return null;
    }

    @Override
    public void add(Car car) {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("brand", car.getBrand());
        paramsMap.put("model", car.getModel());
        paramsMap.put("mileage", car.getMileage());
        paramsMap.put("colour", car.getColour());
        this.namedParameterJdbcTemplate.update(
                SQL_ADD_CAR, paramsMap
        );
    }

    @Override
    public void update(Car car) {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("brand", car.getBrand());
        paramsMap.put("model", car.getModel());
        paramsMap.put("mileage", car.getMileage());
        paramsMap.put("colour", car.getColour());
        paramsMap.put("idCar", car.getId());
        this.namedParameterJdbcTemplate.update(
                SQL_UPDATE_CAR, paramsMap
        );
    }

    @Override
    public void delete(int id) {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("idCar", id);
        this.namedParameterJdbcTemplate.update(
                SQL_DELETE_CAR, paramsMap
        );
    }
}
