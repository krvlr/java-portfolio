package ru.kpfu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.dao.WeatherDao;
import ru.kpfu.model.WeatherModel;

@Service
public class WeatherService {

    @Autowired
    WeatherDao weatherDao;

    public WeatherModel getWeather(String city) {
        return weatherDao.getWeatherData(city);
    }

}
