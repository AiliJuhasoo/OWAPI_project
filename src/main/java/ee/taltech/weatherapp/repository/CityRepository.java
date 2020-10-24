package ee.taltech.weatherapp.repository;

import ee.taltech.weatherapp.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Override
    Page<City> findAll(Pageable pageable); // be nice and page it when querying all

    // todo find one by city name

//    List<Cities> findAllByCountryId(@Param("country") Countries country); // custom queries look like this
}
