package ru.itis.dao;

import java.util.List;

import ru.itis.models.Car;

public interface CarsDao {
    List<Car> getAll();
    Car find(int id);
    void add(Car car);
    void update(Car car);
    void delete(int id);
}
