package ru.itis.service;

import ru.itis.models.Car;

public interface CarsService {
    Car findCarById(int id);
    void addCar(Car car);
    void updateCar(Car car);
    void deleteCar(int id);
}

