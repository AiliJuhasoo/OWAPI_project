package ee.taltech.weatherapp.openweather;

import ee.taltech.weatherapp.util.UrlBuilder;
import ee.taltech.weatherapp.openweather.model.OwResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherGateway {

    @Autowired
    private RestTemplate restTemplate;

    public OwResponse queryForForecast(String period, String latitude, String longitude) {
        ResponseEntity<OwResponse> entity =
                restTemplate.getForEntity(UrlBuilder.buildUrl(period, latitude, longitude), OwResponse.class);

        // Errors retrieving data?

        return entity.getBody();
    }

}
