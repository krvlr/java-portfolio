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
import ru.kpfu.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginGet() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loginPost(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        String newToken = userService.login(userName, password);
        if (newToken != null) {
            Cookie tokenCookie = new Cookie("token", newToken);
            tokenCookie.setMaxAge(600);
            response.addCookie(tokenCookie);
            modelAndView.setViewName("redirect:/profile");
        } else {
            modelAndView.setViewName("redirect:/login");
        }
        return modelAndView;
    }
}
