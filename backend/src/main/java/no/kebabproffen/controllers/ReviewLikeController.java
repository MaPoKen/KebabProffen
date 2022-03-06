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

import no.kebabproffen.models.ReviewLike;
import no.kebabproffen.repositories.ReviewLikeRepository;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/like/review")
public class ReviewLikeController {

    private final ReviewLikeRepository repository;

    public ReviewLikeController(ReviewLikeRepository repository){
        this.repository = repository;
    }

    @GetMapping(value="/")
    public List<ReviewLike> getReviewLikes() {
        return repository.findAll();
    }

    @PostMapping(value = "/")
    ReviewLike createReviewLike(@RequestBody ReviewLike reviewLike){
        return repository.save(reviewLike);
    }
    
    @GetMapping(value = "/{reviewLikeId}")
    ReviewLike getReviewLike(@PathVariable UUID reviewLikeId){
        return repository.getById(reviewLikeId);
    }

    @DeleteMapping(value = "/{reviewLikeId}")
    void deleteReviewLike(@PathVariable UUID reviewLikeId){
        repository.deleteById(reviewLikeId);
    }
    
}
