package ru.itis.controllers;

import ru.itis.models.Car;
import ru.itis.models.CarUser;
import ru.itis.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.service.CarsAndUsersService;
import ru.itis.service.CarsService;
import ru.itis.service.UsersService;

import java.util.List;

@Controller
public class ListController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private CarsService carsService;
    @Autowired
    private CarsAndUsersService carsAndUsersService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView showListGet() {
        ModelAndView modelAndView = new ModelAndView();

        List<User> users = usersService.getAllUser();
        List<Car> cars = carsService.getAllCar();
        List<CarUser> idCarsAndUsers = carsAndUsersService.getAll();

        modelAndView.setViewName("list");

        modelAndView.addObject("usersJsp", users);
        modelAndView.addObject("carsJsp", cars);
        modelAndView.addObject("idCarsAndUsersJsp", idCarsAndUsers);

        return modelAndView;
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ModelAndView showListPost() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list");
        return modelAndView;
    }
}
