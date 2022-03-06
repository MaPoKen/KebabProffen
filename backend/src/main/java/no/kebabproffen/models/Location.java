package no.kebabproffen.models;

import javax.persistence.*;

@Entity
@Table(name = "location")
public class Location{    
    @Id
    @GeneratedValue
    @Column(name = "location_id")
    private int locationId;

    private double longitude;
    
    private double latitude;
    
    private String city;
    
    private String country;

    public Location(int locationId, double longitude, double latitude, String city, String country ){
        this.locationId = locationId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.city = city;
        this.country = country;
    }

}