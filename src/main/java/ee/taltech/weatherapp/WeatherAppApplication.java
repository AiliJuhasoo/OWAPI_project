package ee.taltech.weatherapp;

import com.fasterxml.classmate.TypeResolver;
import ee.taltech.weatherapp.model.responses.ApiResponseFailure;
import ee.taltech.weatherapp.model.responses.ApiResponseSuccess;
import ee.taltech.weatherapp.service.CityService;
import ee.taltech.weatherapp.service.CountryService;
import ee.taltech.weatherapp.util.CSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class WeatherAppApplication {

	@Autowired
	private TypeResolver typeResolver;

	public static void main(String[] args) {

		SpringApplication.run(WeatherAppApplication.class, args);
	}

	@Bean
	CommandLineRunner initUserDatabase(CountryService countryService, CityService cityService) {
		return args -> {
			countryService.saveAll();
			cityService.saveAll();
		};
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		// Additional configuration can be added here, if necessary
		return builder.build();
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/**"))
				.build()
				.additionalModels(typeResolver.resolve(ApiResponseFailure.class),
						typeResolver.resolve(ApiResponseSuccess.class));
	}
}
