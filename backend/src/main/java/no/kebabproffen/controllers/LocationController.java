package no.kebabproffen.controllers;

import java.util.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import no.kebabproffen.models.Location;
import no.kebabproffen.repositories.LocationRepository;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/location")
public class LocationController {

    private final LocationRepository repository;

    public LocationController(LocationRepository repository){
        this.repository = repository;
    }

    @GetMapping(value="/")
    public List<Location> getLocations() {
        return repository.findAll();
    }

    @PostMapping(value = "/")
    Location createLocation(@RequestBody Location location){
        return repository.save(location);
    }
    
    @GetMapping(value = "/{locationId}")
    Location getLocation(@PathVariable UUID locationId){
        return repository.getById(locationId);
    }

    @DeleteMapping(value = "/{locationId}")
    void deleteLocation(@PathVariable UUID locationId){
        repository.deleteById(locationId);
    }
    
}
