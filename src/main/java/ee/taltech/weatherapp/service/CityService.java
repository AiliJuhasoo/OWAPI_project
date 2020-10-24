package ee.taltech.weatherapp.service;

import ee.taltech.weatherapp.model.City;
import ee.taltech.weatherapp.repository.CityRepository;
import ee.taltech.weatherapp.util.CSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> saveAll() {
        CSVHelper helper  = new CSVHelper();
        return cityRepository.saveAll(helper.csvToCities());
    }


    public List<City> getAllCities() {
        return cityRepository.findAll();
    }
}
