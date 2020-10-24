package ee.taltech.weatherapp.model.responses;

import ee.taltech.weatherapp.model.responses.contract.WeatherApiResponseTypeInterface;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ApiResponseSuccess {
    private String city;
    private ArrayList<WeatherApiResponseTypeInterface> responseData;
}
