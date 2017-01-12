package ru.kpfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/check")
public class ValidatorRegistrationForm {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/email", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public void checkEmail(@RequestParam("email") String email, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!userService.checkEmail(email)) {
           response.getWriter().write("ok");
       } else {
           response.getWriter().write("error");
       }
    }

    @RequestMapping(value="/login", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public void checkLogin(@RequestParam("login") String login, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!userService.checkLogin(login)) {
            response.getWriter().write("ok");
        } else {
            response.getWriter().write("error");
        }
    }
}
