package no.kebabproffen.controllers;

import java.util.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import no.kebabproffen.models.DAO.ReviewDAO;
import no.kebabproffen.models.DTO.ReviewDTO;
import no.kebabproffen.repositories.ReviewRepository;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/review")
public class ReviewController {

    private final ReviewRepository repository;

    public ReviewController(ReviewRepository repository){
        this.repository = repository;
    }

    @GetMapping(value="/")
    public List<ReviewDTO> getReviews() {
        return repository.findAll().stream().map(ReviewDAO::toDTO).toList();
    }

    @PostMapping(value = "/")
    ReviewDTO createReview(@RequestBody ReviewDTO review){
        return repository.save(review.toDAO()).toDTO();
    }
    
    @GetMapping(value = "/{reviewId}")
    ReviewDTO getReview(@RequestParam UUID reviewId){
        return repository.getById(reviewId).toDTO();
    }

    @DeleteMapping(value = "/{reviewId}")
    void deleteReview(@RequestParam UUID reviewId){
        repository.deleteById(reviewId);
    }
    
}
