package no.kebabproffen.models;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "resturant")
public class Resturant {

    @Id
    @GeneratedValue
    private int resturantId;
    
    @ManyToOne
    private Location location;

    private String name;
    
    private String type;

    public Resturant(int resturantId, Location location, String name, String resturantType){
        this.resturantId = resturantId;
        this.location = location;
        this.name = name;
        this.type = type;
    } 
}