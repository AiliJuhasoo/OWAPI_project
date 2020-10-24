package ee.taltech.weatherapp.service;

import ee.taltech.weatherapp.model.responses.*;
import ee.taltech.weatherapp.model.responses.contract.WeatherApiResponseTypeInterface;
import ee.taltech.weatherapp.openweather.model.OwHourlyResponseData;
import ee.taltech.weatherapp.openweather.model.OwResponseWeather;
import ee.taltech.weatherapp.util.Converter;
import ee.taltech.weatherapp.util.UrlBuilder;
import ee.taltech.weatherapp.openweather.model.OwDailyResponseData;
import ee.taltech.weatherapp.openweather.model.OwResponse;
import ee.taltech.weatherapp.openweather.model.contract.OwResponseDataInterface;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResponseMapper {

    public static final String TODAY = "today";

    public static final String TOMORROW = "tomorrow";

    public static final String ONE_WEEK = "1-week";

    public ApiResponseSuccess mapOpenWeatherToWeatherApiResponse
            (OwResponse owResponse, String period, String cityName, boolean mps, boolean c) {

        ApiResponseSuccess apiResponse = new ApiResponseSuccess();

        apiResponse.setCity(cityName);
        apiResponse.setResponseData(UrlBuilder.isHourly(period) ?
                mapToHourlyResponse(owResponse.getData(), period, mps, c) :
                mapToDailyResponse(owResponse.getData(), mps, c));

        return apiResponse;
    }

    private ArrayList<WeatherApiResponseTypeInterface> mapToDailyResponse
            (List<OwResponseDataInterface> owDailyResponses, boolean mps, boolean c) {

        ArrayList<WeatherApiResponseTypeInterface> apiDailyResponses = new ArrayList<>();

        for (OwResponseDataInterface dailyForecast : owDailyResponses) {
            OwDailyResponseData owDaily = (OwDailyResponseData)dailyForecast;
            WeatherApiDailyResponse dailyResponse = new WeatherApiDailyResponse();

            LocalDateTime date = Converter.convertLongToDateTime(owDaily.getDateTime());

            dailyResponse.setDate(date.toLocalDate().toString());
            dailyResponse.setDayTemperature(Converter.convertTemperature(owDaily.getTemperature().getDay(), c));
            dailyResponse.setNightTemperature(Converter.convertTemperature(owDaily.getTemperature().getNight(), c));
            dailyResponse.setHumidity(owDaily.getHumidity());
            dailyResponse.setPressure(owDaily.getPressure());
            dailyResponse.setWeather(mapWeatherData(owDaily.getWeather().get(0)));
            dailyResponse.setWindSpeed(mps ? owDaily.getWindSpeed() : Converter.convertMpsToMph(owDaily.getWindSpeed()));
            
            apiDailyResponses.add(dailyResponse);
        }

        return apiDailyResponses;
    }

    private ArrayList<WeatherApiResponseTypeInterface> mapToHourlyResponse
            (List<OwResponseDataInterface> owHourlyResponses, String period, boolean mps, boolean c) {

        ArrayList<WeatherApiResponseTypeInterface> apiHourlyResponses = new ArrayList<>();
        WeatherApiHourlyResponse hourlyResponse = new WeatherApiHourlyResponse();
        ArrayList<HourlyResponseData> apiHourlyResponseData = new ArrayList<>();

        LocalDate startDate = getResponseStartDate(owHourlyResponses);

        for (OwResponseDataInterface hourlyForecast : owHourlyResponses) {
            OwHourlyResponseData owHourly = (OwHourlyResponseData)hourlyForecast;

            LocalDate date = Converter.convertLongToDateTime(owHourly.getDateTime()).toLocalDate();

            if (period.equals(TODAY) && date != startDate || period.equals(TOMORROW) && date == startDate) continue;

            hourlyResponse.setDay(date.toString());
            apiHourlyResponseData.add(mapHourlyResponseForAnHour(owHourly, mps, c));
        }

        hourlyResponse.setHourlyResponseData(apiHourlyResponseData);
        apiHourlyResponses.add(hourlyResponse);

        return apiHourlyResponses;
    }

    private HourlyResponseData mapHourlyResponseForAnHour(OwHourlyResponseData owResponse, boolean mps, boolean c) {
        HourlyResponseData hourResponseData = new HourlyResponseData();
        LocalTime time = Converter.convertLongToDateTime(owResponse.getDateTime()).toLocalTime()
                .truncatedTo(ChronoUnit.HOURS);
        hourResponseData.setHour(time.toString());
        hourResponseData.setHumidity(owResponse.getHumidity());
        hourResponseData.setPressure(owResponse.getPressure());
        hourResponseData.setTemperature(Converter.convertTemperature(owResponse.getTemp(), c));
        hourResponseData.setWindSpeed(mps ? owResponse.getWindSpeed() :
                Converter.convertMpsToMph(owResponse.getWindSpeed()));
        hourResponseData.setWeather(mapWeatherData(owResponse.getWeather().get(0)));
        return hourResponseData;
    }

    private ResponseWeather mapWeatherData(OwResponseWeather owWeather) {
        ResponseWeather weather = new ResponseWeather();
        weather.setIcon(owWeather.getIcon());
        weather.setCondition(owWeather.getDescription());
        return weather;
    }

    // Get date from which hourly responses from OW start
    private LocalDate getResponseStartDate(List<OwResponseDataInterface> owHourlyResponses) {
        OwHourlyResponseData owFirstHour = (OwHourlyResponseData)owHourlyResponses.get(0);
        return Converter.convertLongToDateTime(owFirstHour.getDateTime()).toLocalDate();
    }
}
