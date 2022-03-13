package no.kebabproffen.models.DAO;

import javax.persistence.*;

import no.kebabproffen.models.DAOInterface;
import no.kebabproffen.models.DTO.LocationDTO;

@Entity
@Table(name = "location")
public class LocationDAO implements DAOInterface<LocationDTO>{    
    @Id
    @GeneratedValue
    @Column(name = "location_id")
    private int locationId;

    private double longitude;
    
    private double latitude;
    
    private String city;
    
    private String country;

    public LocationDAO(int locationId, double longitude, double latitude, String city, String country ){
        this.locationId = locationId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.city = city;
        this.country = country;
    }

    public LocationDAO(){}

    @Override
    public LocationDTO toDTO() {
        return new LocationDTO(locationId, longitude, latitude, city, country);
    }

}