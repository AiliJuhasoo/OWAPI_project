package ee.taltech.weatherapp.openweather.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import ee.taltech.weatherapp.openweather.model.contract.OwResponseDataInterface;
import lombok.Data;

import java.util.ArrayList;

@Data
public class OwHourlyResponseData implements OwResponseDataInterface {
    @JsonProperty("dt")
    private long dateTime;
    @JsonProperty("temp")
    private double temp;
    @JsonProperty("feels_like")
    private double feelsLike;
    @JsonProperty("pressure")
    private int pressure;
    @JsonProperty("humidity")
    private int humidity;
    @JsonProperty("dew_point")
    private double dewPoint;
    @JsonProperty("clouds")
    private int clouds;
    @JsonProperty("visibility")
    private int visibility;
    @JsonProperty("wind_speed")
    private double windSpeed;
    @JsonProperty("wind_gust")
    private double windGust;
    @JsonProperty("wind_deg")
    private int windDeg;
    @JsonProperty("rain")
    private OwHourlyResponseRain rain;
    @JsonProperty("snow")
    private OwHourlyResponseSnow snow;
    @JsonProperty("weather")
    private ArrayList<OwResponseWeather> weather;
    @JsonProperty("pop")
    private double pop;
}
