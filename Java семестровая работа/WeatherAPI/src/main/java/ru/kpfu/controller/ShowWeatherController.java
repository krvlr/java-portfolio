package ru.kpfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.model.WeatherModel;
import ru.kpfu.service.WeatherService;

@Controller
public class ShowWeatherController {

    @Autowired
    WeatherService weatherService;

    @RequestMapping(value = "/showweather", method = RequestMethod.GET)
    public ModelAndView showWeatherGet() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("showweather");
        return modelAndView;
    }

    @RequestMapping(value = "/showweather", method = RequestMethod.POST)
    public ModelAndView showWeatherPost(@RequestParam("city") String city) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("showweather");
        WeatherModel weatherModel = weatherService.getWeather(city);
        modelAndView.addObject("weatherjsp", weatherModel);
        return modelAndView;
    }
}
