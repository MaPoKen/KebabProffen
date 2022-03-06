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

import no.kebabproffen.models.Comment;
import no.kebabproffen.repositories.CommentRepository;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentRepository repository;

    public CommentController(CommentRepository repository){
        this.repository = repository;
    }

    @GetMapping(value="/")
    public List<Comment> getComments() {
        return repository.findAll();
    }

    @PostMapping(value = "/")
    Comment createComment(@RequestBody Comment comment){
        return repository.save(comment);
    }
    
    @GetMapping(value = "/{commentId}")
    Comment getComment(@PathVariable UUID commentId){
        return repository.getById(commentId);
    }

    @DeleteMapping(value = "/{commentId}")
    void deleteComment(@PathVariable UUID commentId){
        repository.deleteById(commentId);
    }
    
}
