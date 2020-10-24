package ee.taltech.weatherapp.model;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@Entity
@NoArgsConstructor
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @NotNull
    private double latitude;

    @NotNull
    private double longitude;


    @NotNull
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "countryId", referencedColumnName = "id")
    private Country country;

    public City(Long id, String name, double latitude, double longitude, Country country){

        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Country getCountry(){
        return country;
    }

    public void setCountry(Country country){
        this.country = country;
    }

    @Override
    public String toString() {
        return "Cities [id=" + id + ", name=" + name + ", latitude=" + latitude + ", longitude=" + longitude + ", country=" + country + "]";
    }
}