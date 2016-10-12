package dao;

import models.Car;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class CarsDaoJdbcImpl implements CarsDao {

    // language=SQL
    public static final String SQL_SELECT_ALL_CARS = "SELECT * FROM cars;";
    // language=SQL
    public static final String SQL_ADD_CAR = "INSERT INTO cars(mileage, colour) VALUES (?, ?)";
    // language=SQL
    public static final String SQL_UPDATE_CAR = "";
    // language=SQL
    public static final String SQL_DELETE_CAR = "";


    @Override
    public List<Car> getAll() {
        List<Car> allCars = new ArrayList<Car>();
        try{

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
    public void add() {
        try{

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void update() {
        try{

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try{

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
