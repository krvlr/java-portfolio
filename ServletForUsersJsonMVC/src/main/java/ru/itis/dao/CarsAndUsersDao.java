package ru.itis.dao;

import ru.itis.models.Car;
import ru.itis.models.CarUser;
import ru.itis.models.User;

import java.util.List;

public interface CarsAndUsersDao {
    List<CarUser> getAll();
    void addCarUser(Car car, User user);
}
