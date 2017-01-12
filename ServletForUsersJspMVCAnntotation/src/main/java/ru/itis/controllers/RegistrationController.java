package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.User;
import ru.itis.service.UsersService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

@Controller
public class RegistrationController {
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registrationGet() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registrationPost(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                                         @RequestParam("dateOfBirth") String dateOfBirth, @RequestParam("city") String city,
                                         @RequestParam("login") String login,
                                         @RequestParam("password") String password) {
        ModelAndView modelAndView = new ModelAndView();

        GregorianCalendar cal = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            cal.setTime(sdf.parse(dateOfBirth));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.usersService.addUser(new User(1, firstName, lastName, cal.getTime(), city, login, password, "NULL"));

        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }
}
