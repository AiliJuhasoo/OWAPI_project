package ee.taltech.weatherapp.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import ee.taltech.weatherapp.model.City;
import ee.taltech.weatherapp.model.Country;
import ee.taltech.weatherapp.service.CountryService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CSVHelper {

    @Autowired
    CountryService countryService;

    private static final String COUNTRIES_FILE = "Country.csv";
    private static final String CITIES_FILE = "City.csv";

    public List<Country> csvToCountries() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(COUNTRIES_FILE));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Country> countryList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Country country = new Country(
                        Long.parseLong(csvRecord.get("Id")),
                        csvRecord.get("Name"),
                        csvRecord.get("CountryCode")
                );

                countryList.add(country);
            }

            return countryList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public List<City> csvToCities() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(CITIES_FILE));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<City> cityList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                City city = new City(
                        Long.parseLong(csvRecord.get("Id")),
                        csvRecord.get("Name"),
                        Double.parseDouble(csvRecord.get("Latitude")),
                        Double.parseDouble(csvRecord.get("Longitude")),
                        countryService.findById(Long.parseLong(csvRecord.get("CountryId")))
                );

                cityList.add(city);
            }

            return cityList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
