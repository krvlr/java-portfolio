package service;

import dao.CarsDao;
import models.Car;

import java.util.List;

public class CarsServiceImpl implements CarsService {
    private CarsDao carsDao;

    public CarsServiceImpl(CarsDao carsDao){
        this.carsDao = carsDao;
    }

    @Override
    public List<Car> getAllCar() {
        return carsDao.getAll();
    }

    @Override
    public Car findCarById(int id) {
        return carsDao.find(id);
    }

    @Override
    public Car findCarByParam(Car car) {
        List<Car> cars = this.carsDao.getAll();
        for(Car oneCar : cars){
            if (oneCar.getBrand().equals(car.getBrand()) &&
                    oneCar.getModel().equals(car.getModel()) &&
                    oneCar.getMileage() == car.getMileage()){
                return oneCar;
            }
        }
        return null;
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
