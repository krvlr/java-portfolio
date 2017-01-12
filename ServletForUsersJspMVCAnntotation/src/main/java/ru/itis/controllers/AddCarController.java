package ru.itis.controllers;

import ru.itis.models.Car;
import ru.itis.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.service.CarsAndUsersService;
import ru.itis.service.CarsService;
import ru.itis.service.UsersService;

@Controller
public class AddCarController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private CarsService carsService;
    @Autowired
    private CarsAndUsersService carsAndUsersService;

    @RequestMapping(value = "/addCar", method = RequestMethod.GET)
    public ModelAndView addCarGet() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addCar");
        return modelAndView;
    }

    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public ModelAndView addCarPost(@RequestParam("brand") String brand, @RequestParam("model") String model,
                               @RequestParam("mileage") int mileage, @RequestParam("colour") String colour,
                               @CookieValue("token") String token) {
        ModelAndView modelAndView = new ModelAndView();

        if (!token.equals("")){
            User user = this.usersService.findUserByToken(token);
            if (user != null) {
                Car newCar = new Car(1, brand, model, mileage, colour);
                carsService.addCar(newCar);
                carsAndUsersService.addCarUser(carsService.findCarByParam(newCar),user);
            }
        }
        modelAndView.setViewName("redirect:/list");
        return modelAndView;
    }
}
