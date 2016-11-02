package dao;

import java.util.List;

import models.Car;

public interface CarsDao {
    List<Car> getAll();
    Car find(int id);
    void add(Car car);
    void update(Car car);
    void delete(int id);
}
