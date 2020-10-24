package ee.taltech.weatherapp.model.responses;

import ee.taltech.weatherapp.model.responses.contract.WeatherApiResponseTypeInterface;
import lombok.Data;

@Data
public class WeatherApiDailyResponse implements WeatherApiResponseTypeInterface {
    private String date;
    private ResponseWeather weather;
    private double dayTemperature;
    private double nightTemperature;
    private int humidity;
    private double windSpeed;
    private double pressure;
}
