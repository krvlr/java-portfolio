package ru.kpfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.model.User;
import ru.kpfu.model.VideoTutorial;
import ru.kpfu.service.UserService;
import ru.kpfu.service.VideoTutorialService;

import java.util.List;

@Controller
public class ListVideoTutorialController {

    @Autowired
    private VideoTutorialService videoTutorialService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/listvideo", method = RequestMethod.GET)
    public ModelAndView showListGet() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("listvideo");
        List<VideoTutorial> videoTutorials = videoTutorialService.getAllVideoTutorial();
        modelAndView.addObject("videoTutorialsJsp", videoTutorials);
        List<User> users = userService.getAllNames();
        modelAndView.addObject("usersJsp", users);
        return modelAndView;
    }

    @RequestMapping(value = "/listvideo", method = RequestMethod.POST)
    public ModelAndView showListPost() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("listvideo");
        return modelAndView;
    }
}
