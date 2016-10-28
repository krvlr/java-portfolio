package dao;

import models.Car;
import models.CarUser;
import models.User;

import java.util.List;

public interface CarsAndUsersDao {
    List<CarUser> getAll();
    void addCarUser(Car car, User user);
}
