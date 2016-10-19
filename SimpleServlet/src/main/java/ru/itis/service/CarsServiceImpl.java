package ru.itis.service;

import ru.itis.dao.CarsDao;
import ru.itis.models.Car;

public class CarsServiceImpl implements CarsService {

    private CarsDao carsDao;

    public CarsServiceImpl(CarsDao carsDao){
        this.carsDao = carsDao;
    }

    @Override
    public Car findCarById(int id) {
        return carsDao.find(id);
    }

    @Override
    public void addCar(Car car){
        carsDao.add(car);
    }

    @Override
    public void updateCar(Car car) {
        carsDao.update(car);
    }

    @Override
    public void deleteCar(int id){
        carsDao.delete(id);
    }
}
