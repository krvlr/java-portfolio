package ru.itis.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.models.Car;
import ru.itis.models.CarUser;
import ru.itis.models.User;
import ru.itis.service.CarsAndUsersService;
import ru.itis.service.CarsService;
import ru.itis.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RestController extends HttpServlet {
    @Autowired
    private UsersService usersService;
    @Autowired
    private CarsService carsService;
    @Autowired
    private CarsAndUsersService carsAndUsersService;

    ObjectMapper objectMapper;

    @Override
    public void init() throws ServletException {
        try {
            super.init();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        objectMapper = new ObjectMapper();
    }

    @RequestMapping(value = "/allusers", method = RequestMethod.GET,
            produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<User> getAllUsers(@RequestHeader("token") String token) {
        if (this.usersService.findUserByToken(token) != null) {
            List<User> allUsers = this.usersService.getAllUser();
            return allUsers;
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET,
            produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<User> getUsersByCity(@RequestParam("city") String userCity, @RequestHeader("token") String token) {
        if (this.usersService.findUserByToken(token) != null) {
            List<User> allUsers = this.usersService.getAllUser();
            List<User> usersByCity = new ArrayList<User>();
            for (User user : allUsers) {
                if (user.getCity().equals(userCity)) {
                    usersByCity.add(user);
                }
            }
            return usersByCity;
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/users/{user-id}/cars", method = RequestMethod.GET,
            produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<Car> getCars(@PathVariable("user-id") int idUser, @RequestHeader("token") String token) {
        if (this.usersService.findUserByToken(token) != null) {
            List<CarUser> carsUsers = carsAndUsersService.getAll();
            List<Car> cars = new ArrayList<Car>();
            for (CarUser carUser : carsUsers) {
                if (carUser.getIdUser() == idUser) {
                    cars.add(this.carsService.findCarById(carUser.getIdCar()));
                }
            }
            return cars;
        } else {
            return null;
        }

    }

    @RequestMapping(value = "/users/{user-id}/addcars", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseEntity<Car> postAddCar(@PathVariable("user-id") int idUser, @RequestBody Car newCar, @RequestHeader("token") String token) {
        if (this.usersService.findUserByToken(token) != null) {
            carsService.addCar(newCar);
            carsAndUsersService.addCarUser(newCar, usersService.findUserById(idUser));

            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("NewCar info: ", newCar.toString());
            ResponseEntity<Car> response = new ResponseEntity<Car>(newCar, responseHeaders, HttpStatus.CREATED);
            return response;
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseBody
    public String postLogin(@RequestParam("login") String login, @RequestParam("password") String password) {
        User user = this.usersService.findUserByLoginAndPassword(login, password);
        if (user != null){
            return this.usersService.setNewToken(user);

        } else{
            return "";
        }
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseBody
    public void postRegistration(@RequestBody User newUser) {
        this.usersService.addUser(newUser);
    }
}
