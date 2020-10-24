package ee.taltech.weatherapp.openweather.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import ee.taltech.weatherapp.openweather.model.contract.OwResponseDataInterface;
import lombok.Data;

import java.util.ArrayList;

@Data
public class OwResponse {

    @JsonProperty("lat")
    private double latitude;

    @JsonProperty("lon")
    private double longitude;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("timezone_offset")
    private String timezoneOffset;

    @JsonAlias({"daily", "hourly"})
    private ArrayList<OwResponseDataInterface> data;

}
