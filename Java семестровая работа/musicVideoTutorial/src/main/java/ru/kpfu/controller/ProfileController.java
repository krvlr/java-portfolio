package ru.kpfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.model.User;
import ru.kpfu.service.UserService;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView profileGet(@CookieValue("token") String token) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profile");
        User user = userService.findByToken(token);
        if (user != null) {
            modelAndView.addObject("userInfoJsp", user);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public ModelAndView profilePost() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list");
        return modelAndView;
    }
}
