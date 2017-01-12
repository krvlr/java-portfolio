package ru.itis.service;

import ru.itis.dao.CarsDao;
import ru.itis.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsServiceImpl implements CarsService {
    @Autowired
    private CarsDao carsDao;

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
