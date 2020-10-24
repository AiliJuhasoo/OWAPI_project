package ee.taltech.weatherapp.model.responses;

import lombok.Data;

@Data
public class ResponseWeather {
    private String condition;
    private String icon;
}
