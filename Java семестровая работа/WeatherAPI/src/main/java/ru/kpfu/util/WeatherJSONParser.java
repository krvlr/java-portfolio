package ru.kpfu.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Repository;
import ru.kpfu.model.WeatherModel;

@Repository
public class WeatherJSONParser {
    public WeatherModel getWeatherFromJSON(String jsonLine) {
        String sost = "";
        float temp = 0;
        int pressure = 0;
        byte humidity = 0;
        try {
            JSONObject weatherJsonObject = (JSONObject) JSONValue.parseWithException(jsonLine);
            JSONArray weatherArray = (JSONArray) weatherJsonObject.get("weather");
            JSONObject weatherData = (JSONObject) weatherArray.get(0);
            sost = (String) weatherData.get("main");
            JSONObject mainData = (JSONObject) weatherJsonObject.get("main");
            temp = Float.parseFloat(mainData.get("temp").toString());
            pressure = Integer.parseInt(mainData.get("pressure").toString());
            humidity = (byte) Integer.parseInt(mainData.get("humidity").toString());

        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return new WeatherModel(sost, temp, pressure, humidity);
    }
}
