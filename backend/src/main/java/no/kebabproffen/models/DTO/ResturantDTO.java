package no.kebabproffen.models.DTO;

import javax.persistence.*;

import no.kebabproffen.models.DTOInterface;
import no.kebabproffen.models.DAO.ResturantDAO;

import java.util.*;

public class ResturantDTO implements DTOInterface<ResturantDAO>{

    private int resturantId;
    private LocationDTO location;
    private String name;
    private String type;

    public ResturantDTO(int resturantId, LocationDTO location, String name, String type){
        this.resturantId = resturantId;
        this.location = location;
        this.name = name;
        this.type = type;
    }

    @Override
    public ResturantDAO toDAO() {
        return new ResturantDAO(resturantId, location.toDAO(), name, type);
    } 
}