package ee.taltech.weatherapp.util;

import ee.taltech.weatherapp.configuration.OpenWeatherConfig;
import ee.taltech.weatherapp.exception.InvalidForecastPeriodException;
import ee.taltech.weatherapp.service.ResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

import static java.util.Map.entry;

@Component
@EnableConfigurationProperties(OpenWeatherConfig.class)
public class UrlBuilder {

    @Autowired
    private static OpenWeatherConfig config;

    private static final String COMMON_EXCLUDE = "&exclude=current,minutely,alerts,";

    private static final String HOURLY_EXCLUDE = "daily";

    private static final String DAILY_EXCLUDE = "hourly";

    private static Map<String, String> urlMap = Map.ofEntries(
            entry(ResponseMapper.TODAY, HOURLY_EXCLUDE),
            entry(ResponseMapper.TOMORROW, HOURLY_EXCLUDE),
            entry(ResponseMapper.ONE_WEEK, DAILY_EXCLUDE)
    );

    public static String buildUrl(String period, String latitude, String longitude) {
        if (!urlMap.containsKey(period)) {
            throw new InvalidForecastPeriodException("Invalid forecast period option was selected!");
        }

        return config.getUrl() + "?lat=" + latitude + "&lon=" + longitude + COMMON_EXCLUDE + urlMap.get(period) +
                "&appid=" + config.getKey();
    }

    public static boolean isHourly(String period) {
        if (!urlMap.containsKey(period)) {
            throw new InvalidForecastPeriodException("Invalid forecast period option was selected!");
        }

        return urlMap.get(period).equals(HOURLY_EXCLUDE);
    }
}
