package ee.taltech.weatherapp.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.open-weather")
public class OpenWeatherConfig {
    private String url;
    private String key;
}
