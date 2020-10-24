package ee.taltech.weatherapp.openweather.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import ee.taltech.weatherapp.openweather.model.contract.OwResponseDataInterface;
import lombok.Data;

import java.util.ArrayList;

@Data
public class OwDailyResponseData implements OwResponseDataInterface {

    @JsonProperty("dt")
    private long dateTime;

    @JsonProperty("sunrise")
    private long sunrise;

    @JsonProperty("sunset")
    private long sunset;

    @JsonProperty("temp")
    private OwResponseTemperature temperature;

    @JsonProperty("feels_like")
    private OwResponseFeelsLike feelsLike;

    @JsonProperty("pressure")
    private int pressure;

    @JsonProperty("humidity")
    private int humidity;

    @JsonProperty("dew_point")
    private double dewPoint;

    @JsonProperty("wind_speed")
    private double windSpeed;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("wind_gust")
    private double windGust;

    @JsonProperty("wind_deg")
    private int windDegree;

    @JsonProperty("weather")
    private ArrayList<OwResponseWeather> weather;

    @JsonProperty("clouds")
    private int clouds;

    @JsonProperty("pop")
    private double pop;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("rain")
    private double rain;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("snow")
    private double snow;

    @JsonProperty("uvi")
    private double uvi;

}
