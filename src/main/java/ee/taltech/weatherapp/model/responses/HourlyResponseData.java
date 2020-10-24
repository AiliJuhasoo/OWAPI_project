package ee.taltech.weatherapp.model.responses;

import lombok.Data;

@Data
public class HourlyResponseData {
    private String hour;
    private ResponseWeather weather;
    private double temperature;
    private int humidity;
    private double windSpeed;
    private double pressure;
}
