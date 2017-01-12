package ru.kpfu.model;

import com.google.common.base.MoreObjects;

public class WeatherModel {

    private String sost;
    private float temp;
    private int pressure;
    private byte humidity;

    public WeatherModel(String sost, float temp, int pressure, byte humidity) {
        this.sost = sost;
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public String getSost() {
        return sost;
    }

    public float getTemp() {
        return temp;
    }

    public int getPressure() {
        return pressure;
    }

    public byte getHumidity() {
        return humidity;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("sost", this.sost)
                .add("temp", this.temp)
                .add("pressure", this.pressure)
                .add("humidity", this.humidity)
                .toString();
    }
}
