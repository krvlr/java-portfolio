package ru.itis.service;

import ru.itis.dao.CarsAndUsersDao;
import ru.itis.models.Car;
import ru.itis.models.CarUser;
import ru.itis.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsAndUsersServiceImpl implements CarsAndUsersService {
    @Autowired
    private CarsAndUsersDao carsAndUsersDao;

    @Override
    public List<CarUser> getAll(){
        return  this.carsAndUsersDao.getAll();
    }

    @Override
    public void addCarUser(Car car, User user) {
        this.carsAndUsersDao.addCarUser(car, user);
    }
}
