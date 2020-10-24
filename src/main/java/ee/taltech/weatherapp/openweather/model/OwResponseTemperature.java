package ee.taltech.weatherapp.openweather.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OwResponseTemperature {

    @JsonProperty("day")
    private long day;
    @JsonProperty("min")
    private long min;
    @JsonProperty("max")
    private long max;
    @JsonProperty("night")
    private long night;
    @JsonProperty("eve")
    private long eve;
    @JsonProperty("morn")
    private long morning;

}
