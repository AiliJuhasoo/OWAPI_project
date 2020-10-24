package ee.taltech.weatherapp.openweather.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OwHourlyResponseRain {
    @JsonProperty("1h")
    private double perHour;
}
