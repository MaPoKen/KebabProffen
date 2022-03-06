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

import no.kebabproffen.models.Review;
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
    public List<Review> getReviews() {
        return repository.findAll();
    }

    @PostMapping(value = "/")
    Review createReview(@RequestBody Review review){
        return repository.save(review);
    }
    
    @GetMapping(value = "/{reviewId}")
    Review getReview(@RequestParam UUID reviewId){
        return repository.getById(reviewId);
    }

    @DeleteMapping(value = "/{reviewId}")
    void deleteReview(@RequestParam UUID reviewId){
        repository.deleteById(reviewId);
    }
    
}
