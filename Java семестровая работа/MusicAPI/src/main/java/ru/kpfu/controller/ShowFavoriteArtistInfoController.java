package ru.kpfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.service.FavoriteArtistService;

@Controller
public class ShowFavoriteArtistInfoController {

    @Autowired
    FavoriteArtistService favoriteArtistService;

    @RequestMapping(value = "/showartistinfo", method = RequestMethod.GET)
    public ModelAndView showFavoriteGet() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("showartistinfo");
        modelAndView.addObject("allfavoriteartistinfojsp", favoriteArtistService.getAllFavoriteArtistData());
        return modelAndView;
    }

    @RequestMapping(value = "/showartistinfo", method = RequestMethod.POST)
    public ModelAndView showFavoritePost() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("showartistinfo");
        return modelAndView;
    }
}
