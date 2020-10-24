package ee.taltech.weatherapp.openweather.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OwResponseFeelsLike {

    @JsonProperty("day")
    private long day;
    @JsonProperty("night")
    private long night;
    @JsonProperty("eve")
    private long eve;
    @JsonProperty("morn")
    private long morning;

}
