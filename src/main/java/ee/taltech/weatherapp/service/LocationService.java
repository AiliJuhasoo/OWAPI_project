package ee.taltech.weatherapp.service;

import ee.taltech.weatherapp.model.Country;
import ee.taltech.weatherapp.repository.CountryRepository;
import org.springframework.stereotype.Service;
import ee.taltech.weatherapp.repository.CityRepository;

import java.util.Optional;

@Service
public class LocationService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    public LocationService(CityRepository cityRepository, CountryRepository countryRepository) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
    }

    public Optional<Country> getCountryById(Long id) {
        return countryRepository.findById(id);
    }
    // get coordinates from city name
    // get country ID by city name -> get country by id
    // country = city concatenation

    // todo call citiesrepo method get one by name (getcitycoordinates)
}
