package service;

import dao.CarsAndUsersDao;
import models.Car;
import models.CarUser;
import models.User;

import java.util.List;

public class CarsAndUsersServiceImpl implements CarsAndUsersService {

    private CarsAndUsersDao carsAndUsersDao;

    public CarsAndUsersServiceImpl(CarsAndUsersDao carsAndUsersDao) {
        this.carsAndUsersDao = carsAndUsersDao;
    }

    @Override
    public List<CarUser> getAll(){
        return  this.carsAndUsersDao.getAll();
    }

    @Override
    public void addCarUser(Car car, User user) {
        this.carsAndUsersDao.addCarUser(car, user);
    }
}
