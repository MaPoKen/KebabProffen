package no.kebabproffen.controllers;

import java.util.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import no.kebabproffen.models.DAO.ResturantDAO;
import no.kebabproffen.models.DTO.ResturantDTO;
import no.kebabproffen.repositories.ResturantRepository;



@RestController
@RequestMapping("/api/resturant")
public class ResturantController {

    private final ResturantRepository repository;

    public ResturantController(ResturantRepository repository){
        this.repository = repository;
    }

    @GetMapping(value="/")
    public List<ResturantDTO> getResturants() {
        return repository.findAll().stream().map(ResturantDAO::toDTO).toList();
    }

    @PostMapping(value = "/")
    ResturantDTO createResturant(@RequestBody ResturantDTO resturant){
        return repository.save(resturant.toDAO()).toDTO();
    }
    
    @GetMapping(value = "/{resturantId}")
    ResturantDTO getResturant(@PathVariable UUID resturantId){
        return repository.getById(resturantId).toDTO();
    }

    @DeleteMapping(value = "/{resturantId}")
    void deleteResturant(@PathVariable UUID resturantId){
        repository.deleteById(resturantId);
    }
    
}
