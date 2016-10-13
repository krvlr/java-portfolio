package tests;

import dao.CarsDaoJdbcImpl;
import factories.JdbcConnection;
import models.Car;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CarsDaoJdbcImplTest {

    private CarsDaoJdbcImpl carsDaoJdbc;

    @Before
    public void setUp() throws Exception {
        carsDaoJdbc = new CarsDaoJdbcImpl(JdbcConnection.getInstance().getConnection());
    }

    @Test
    public void getAll() throws Exception {
        List<Car> cars = carsDaoJdbc.getAll();
        for(Car car : cars){
            System.out.println(car);
        }
    }

    @Test
    public void find() throws Exception {
        Car car = carsDaoJdbc.find(5);
        System.out.println(car);
    }

    @Test
    public void add() throws Exception {
        Car newCar = new Car(11, 65, "dark");
        carsDaoJdbc.add(newCar);
    }

    @Test
    public void update() throws Exception {
        Car updateCat = new Car(11, 70, "dark");
        carsDaoJdbc.update(updateCat);
    }

    @Test
    public void delete() throws Exception {
        carsDaoJdbc.delete(11);
    }

}