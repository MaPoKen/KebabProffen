package no.kebabproffen.models.DAO;

import javax.persistence.*;

import no.kebabproffen.models.DAOInterface;
import no.kebabproffen.models.DTO.ResturantDTO;


@Entity
@Table(name = "resturant")
public class ResturantDAO implements DAOInterface<ResturantDTO>{

    @Id
    @GeneratedValue
    private int resturantId;
    
    @ManyToOne
    private LocationDAO location;

    private String name;
    
    private String type;

    public ResturantDAO(int resturantId, LocationDAO location, String name, String type){
        this.resturantId = resturantId;
        this.location = location;
        this.name = name;
        this.type = type;
    }
    
    public ResturantDAO(){}

    @Override
    public ResturantDTO toDTO() {
        return new ResturantDTO(resturantId, location.toDTO(), name, type);
    } 
}