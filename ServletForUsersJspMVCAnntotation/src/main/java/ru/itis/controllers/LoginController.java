package ru.itis.controllers;

import ru.itis.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.service.UsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginGet() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loginPost(@RequestParam("login") String login, @RequestParam("password") String password,
                              HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();

        User user = this.usersService.findUserByLoginAndPassword(login, password);
        if (user != null){
            String token = usersService.setNewToken(user);
            Cookie tokenCookie = new Cookie("token", token);
            tokenCookie.setMaxAge(600);
            response.addCookie(tokenCookie);
            modelAndView.setViewName("redirect:/list");
        } else{
            modelAndView.addObject("error", "Incorrect params");
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

}
