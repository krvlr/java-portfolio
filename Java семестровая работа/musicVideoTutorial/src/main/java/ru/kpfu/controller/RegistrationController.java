/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kpfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.model.User;
import ru.kpfu.service.UserService;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registrationGet() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registrationPost(@RequestParam("login") String login, @RequestParam("password") String password,
                                         @RequestParam("email") String email, @RequestParam("country") String country,
                                         @RequestParam("sex") String sex) {
        ModelAndView modelAndView = new ModelAndView();
        userService.registration(new User(0, login, password, email, country, sex, ""));
        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }
}

