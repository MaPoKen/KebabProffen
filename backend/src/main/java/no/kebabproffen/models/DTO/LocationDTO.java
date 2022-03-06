package no.kebabproffen.models.DTO;

import no.kebabproffen.models.DTOInterface;
import no.kebabproffen.models.DAO.LocationDAO;

public class LocationDTO implements DTOInterface<LocationDAO> {    

    private int locationId;
    private double longitude;
    private double latitude;
    private String city;
    private String country;

    public LocationDTO(int locationId, double longitude, double latitude, String city, String country ){
        this.locationId = locationId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.city = city;
        this.country = country;
    }

    @Override
    public LocationDAO toDAO() {
        return new LocationDAO(locationId, longitude, latitude, city, country);
    }

}