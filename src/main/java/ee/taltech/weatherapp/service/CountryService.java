package ee.taltech.weatherapp.service;

import ee.taltech.weatherapp.model.Country;
import ee.taltech.weatherapp.repository.CountryRepository;
import ee.taltech.weatherapp.util.CSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    CountryRepository countryRepository;

    public void saveAll() {
        countryRepository.saveAll(new CSVHelper().csvToCountries());
    }


    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country findById(Long id) {
        return countryRepository.findById(id).orElseThrow();
    }
}
