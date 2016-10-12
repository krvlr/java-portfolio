package dao;

import models.Car;
import singletone.JdbcConnection;

import java.lang.ref.SoftReference;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarsDaoJdbcImpl implements CarsDao {

    // language=SQL
    public static final String SQL_SELECT_ALL_CARS = "SELECT * FROM cars;";
    // language=SQL
    public static final String SQL_ADD_CAR = "INSERT INTO cars(mileage, colour) VALUES (?, ?);";
    // language=SQL
    public static final String SQL_UPDATE_CAR = "UPDATE cars SET mileage = ?, colour = ? WHERE id_car = ?;";
    // language=SQL
    public static final String SQL_DELETE_CAR = "DELETE FROM cars WHERE id_car = ?;";

    private Connection connection;
    private Statement statement;

    public CarsDaoJdbcImpl(){
        try{
            connection = JdbcConnection.getInstance().getConnection();
            statement = connection.createStatement();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Car> getAll() {
        List<Car> allCars = new ArrayList<Car>();
        try{
            ResultSet result = statement.executeQuery(SQL_SELECT_ALL_CARS);
            while(result.next()) {
                allCars.add(new Car(result.getInt("id_car"), result.getInt("mileage"), result.getString("colour")));
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return allCars;
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
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_CAR);

            preparedStatement.setInt(1, car.getMileage());
            preparedStatement.setString(2, car.getColour());

            preparedStatement.execute();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Car car) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_CAR);

            preparedStatement.setInt(1, car.getMileage());
            preparedStatement.setString(2, car.getColour());
            preparedStatement.setInt(3, car.getId());

            preparedStatement.execute();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_CAR);

            preparedStatement.setInt(1, id);

            preparedStatement.execute();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
