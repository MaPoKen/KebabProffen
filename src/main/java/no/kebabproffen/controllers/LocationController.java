package no.kebabproffen.controllers;

import java.util.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import no.kebabproffen.models.DAO.LocationDAO;
import no.kebabproffen.models.DTO.LocationDTO;
import no.kebabproffen.repositories.LocationRepository;



@RestController
@RequestMapping("/api/location")
public class LocationController {

    private final LocationRepository repository;

    public LocationController(LocationRepository repository){
        this.repository = repository;
    }

    @GetMapping(value="/")
    public List<LocationDTO> getLocations() {
        return repository.findAll().stream().map(LocationDAO::toDTO).toList();
    }

    @PostMapping(value = "/")
    LocationDTO createLocation(@RequestBody LocationDTO location){
        return repository.save(location.toDAO()).toDTO();
    }
    
    @GetMapping(value = "/{locationId}")
    LocationDTO getLocation(@PathVariable UUID locationId){
        return repository.getById(locationId).toDTO();
    }

    @DeleteMapping(value = "/{locationId}")
    void deleteLocation(@PathVariable UUID locationId){
        repository.deleteById(locationId);
    }
    
}
