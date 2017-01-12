package ru.itis.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.models.User;
import ru.itis.services.ChatService;
import ru.itis.services.MessageService;
import ru.itis.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

@Controller
public class RestController extends HttpServlet {
    @Autowired
    ChatService chatService;
    @Autowired
    MessageService messageService;
    @Autowired
    UserService userService;

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

    @RequestMapping(value = "/login", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseBody
    public String postLogin(@RequestParam("login") String login, @RequestParam("password") String password) {
        User user = this.userService.authorizeUser(login, password);
        if (user != null){
            return this.userService.addTokenForUser();
        } else {
            return "";
        }
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseBody
    public void postRegistration(@RequestBody User newUser) {
        this.userService.registredUser(newUser);
    }
}
