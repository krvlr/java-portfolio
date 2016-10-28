package dao;

import models.Car;
import models.CarUser;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarsAndUsersDaoImpl implements CarsAndUsersDao {
    // language=SQL
    public static final String SQL_GET_ALL_ID = "SELECT * FROM cars_users;";
    // language=SQL
    public static final String SQL_ADD_CAR_USER = "INSERT INTO cars_users(id_car, id_user) VALUES (?, ?);";

    private Connection connection;
    private Statement statement;

    public CarsAndUsersDaoImpl(Connection connection) {
        try{
            this.connection = connection;
            statement = connection.createStatement();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<CarUser> getAll() {
        List<CarUser> idCarsAndUsers = new ArrayList<CarUser>();
        try{
            ResultSet result = statement.executeQuery(SQL_GET_ALL_ID);
            while(result.next()) {
                idCarsAndUsers.add(new CarUser(result.getInt("id_car"), result.getInt("id_user")));
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return idCarsAndUsers;
    }

    @Override
    public void addCarUser(Car car, User user) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_CAR_USER);

            preparedStatement.setInt(1, car.getId());
            preparedStatement.setInt(2, user.getId());

            preparedStatement.execute();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
