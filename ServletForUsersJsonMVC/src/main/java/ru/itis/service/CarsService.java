package ru.itis.service;

import ru.itis.models.Car;

import java.util.List;

public interface CarsService {
    List<Car> getAllCar();
    Car findCarById(int id);
    Car findCarByParam(Car car);
    void addCar(Car car);
    void updateCar(Car car);
    void deleteCar(int id);
}
