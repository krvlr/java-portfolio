package dao;

import models.Car;

import java.util.List;

public interface CarsDao {
    List<Car> getAll();

    Car find(int id);

    void add();

    void update();

    void delete(int id);
}
