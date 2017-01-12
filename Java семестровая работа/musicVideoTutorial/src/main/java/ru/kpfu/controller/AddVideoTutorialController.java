package ru.kpfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.model.User;
import ru.kpfu.model.VideoTutorial;
import ru.kpfu.service.UserService;
import ru.kpfu.service.VideoTutorialService;

@Controller
public class AddVideoTutorialController {

    @Autowired
    private VideoTutorialService videoTutorialService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addvideo", method = RequestMethod.GET)
    public ModelAndView addVideoGet() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addvideo");
        return modelAndView;
    }

    @RequestMapping(value = "/addvideo", method = RequestMethod.POST)
    public ModelAndView addVideoPost(@CookieValue("token") String token,
                                     @RequestParam("description") String description) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findByToken(token);
        if (user != null) {
            videoTutorialService.addVideoTutorial(new VideoTutorial(0, user.getUserId(), description));
        }
        modelAndView.setViewName("addvideo");
        return modelAndView;
    }
}
