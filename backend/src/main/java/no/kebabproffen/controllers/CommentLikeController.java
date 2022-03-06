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

import no.kebabproffen.models.CommentLike;
import no.kebabproffen.repositories.CommentLikeRepository;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/like/comment")
public class CommentLikeController {

    private final CommentLikeRepository repository;

    public CommentLikeController(CommentLikeRepository repository){
        this.repository = repository;
    }

    @GetMapping(value="/")
    public List<CommentLike> getCommentLikes() {
        return repository.findAll();
    }

    @PostMapping(value = "/")
    CommentLike createCommentLike(@RequestBody CommentLike commentLike){
        return repository.save(commentLike);
    }
    
    @GetMapping(value = "/{commentLikeId}")
    CommentLike getCommentLike(@PathVariable UUID commentLikeId){
        return repository.getById(commentLikeId);
    }

    @DeleteMapping(value = "/{commentLikeId}")
    void deleteCommentLike(@PathVariable UUID commentLikeId){
        repository.deleteById(commentLikeId);
    }
    
}
