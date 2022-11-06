package no.kebabproffen.controllers;

import java.util.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import no.kebabproffen.models.DAO.ReviewLikeDAO;
import no.kebabproffen.models.DTO.ReviewLikeDTO;
import no.kebabproffen.repositories.ReviewLikeRepository;



@RestController
@RequestMapping("/api/like/review")
public class ReviewLikeController {

    private final ReviewLikeRepository repository;

    public ReviewLikeController(ReviewLikeRepository repository){
        this.repository = repository;
    }

    @GetMapping(value="/")
    public List<ReviewLikeDTO> getReviewLikes() {
        return repository.findAll().stream().map(ReviewLikeDAO::toDTO).toList();
    }

    @PostMapping(value = "/")
    ReviewLikeDTO createReviewLike(@RequestBody ReviewLikeDTO reviewLike){
        return repository.save(reviewLike.toDAO()).toDTO();
    }
    
    @GetMapping(value = "/{reviewLikeId}")
    ReviewLikeDTO getReviewLike(@PathVariable UUID reviewLikeId){
        return repository.getById(reviewLikeId).toDTO();
    }

    @DeleteMapping(value = "/{reviewLikeId}")
    void deleteReviewLike(@PathVariable UUID reviewLikeId){
        repository.deleteById(reviewLikeId);
    }
    
}
