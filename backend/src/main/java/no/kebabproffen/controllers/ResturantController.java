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
import org.springframework.http.ResponseEntity;

import no.kebabproffen.models.Resturant;
import no.kebabproffen.repositories.ResturantRepository;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/resturant")
public class ResturantController {

    private final ResturantRepository repository;

    public ResturantController(ResturantRepository repository){
        this.repository = repository;
    }

    @GetMapping(value="/")
    public List<Resturant> getResturants() {
        return repository.findAll();
    }

    @PostMapping(value = "/")
    Resturant createResturant(@RequestBody Resturant resturant){
        return repository.save(resturant);
    }
    
    @GetMapping(value = "/{resturantId}")
    Resturant getResturant(@PathVariable UUID resturantId){
        return repository.getById(resturantId);
    }

    @DeleteMapping(value = "/{resturantId}")
    void deleteResturant(@PathVariable UUID resturantId){
        repository.deleteById(resturantId);
    }
    
}
