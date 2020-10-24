package ee.taltech.weatherapp.controller;

import ee.taltech.weatherapp.model.responses.ApiResponse;
import ee.taltech.weatherapp.service.WeatherApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RequestMapping("")
@RestController
public class WeatherApiController {

    @Autowired
    WeatherApiService weatherApiService;

    private final CacheControl CACHE_CONTROL = CacheControl.maxAge(5, TimeUnit.MINUTES);

    @GetMapping("/")
    public void index() {

    }

    @GetMapping("forecast/{location}/{period}")
    public ResponseEntity<ApiResponse> forecast(@PathVariable String location,
                                                @PathVariable String period,
                                                @RequestParam(defaultValue = "1") boolean mps,
                                                @RequestParam(defaultValue = "1") boolean c) {

        ApiResponse response = new ApiResponse();

        response.setSuccess(true);
        response.setData(weatherApiService.getForecast(period, location, mps, c));

        return ResponseEntity.ok().cacheControl(CACHE_CONTROL).body(response);
    }

}
