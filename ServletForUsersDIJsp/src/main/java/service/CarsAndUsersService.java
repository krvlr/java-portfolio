package service;

import models.Car;
import models.CarUser;
import models.User;

import java.util.List;

public interface CarsAndUsersService {
    List<CarUser> getAll();
    void addCarUser(Car car, User user);
}
