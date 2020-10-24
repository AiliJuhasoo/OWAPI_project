package ee.taltech.weatherapp.service;

import ee.taltech.weatherapp.model.responses.ApiResponseSuccess;
import ee.taltech.weatherapp.openweather.OpenWeatherGateway;
import ee.taltech.weatherapp.openweather.model.OwResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherApiService {
    @Autowired
    private OpenWeatherGateway gateway;

    @Autowired
    private ResponseMapper mapper;

    public ApiResponseSuccess getForecast(String period, String location, boolean mps, boolean c) {
        // Call repo to get coordinates from location
        String cityName = "";
        String latitude = "";
        String longitude = "";
        // Return error if not found
        // Call OWGateway
        OwResponse owResponse = gateway.queryForForecast(period, latitude, longitude);
        // Call mapper on the returned data
        ApiResponseSuccess apiResponse = mapper.mapOpenWeatherToWeatherApiResponse(owResponse, period, cityName, mps, c);

        return apiResponse;
    }
}
