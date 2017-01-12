package ru.kpfu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.model.WeatherModel;
import ru.kpfu.util.WeatherJSONParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Repository
public class WeatherDao {

    private static String GET_WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?APPID=2f0607b13b2e10a32e733734542d2b98&units=metric&q=";

    @Autowired
    WeatherJSONParser weatherJSONParser;

    public WeatherModel getWeatherData(String city){

        HttpURLConnection weatherCon = null;
        InputStream inputStream = null;
        BufferedReader bufferedReader;

        try {
            URL weatherURL = new URL(GET_WEATHER_URL + city);
            weatherCon = (HttpURLConnection) weatherURL.openConnection();
            weatherCon.setRequestMethod("GET");
            weatherCon.setDoInput(true);
            weatherCon.setDoOutput(true);
            weatherCon.connect();

            StringBuffer buffer = new StringBuffer();
            inputStream = weatherCon.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine())!=null){
                buffer.append(line+"\n");
            }
            inputStream.close();
            bufferedReader.close();
            weatherCon.disconnect();

            WeatherModel weatherModel = weatherJSONParser.getWeatherFromJSON(buffer.toString());

            return weatherModel;
        }
        catch (Throwable t){
            t.printStackTrace();
        }
        finally {
            try {
                inputStream.close();
            } catch (Throwable t) {
                weatherCon.disconnect();
            }
        }
        return null;
    }

}
