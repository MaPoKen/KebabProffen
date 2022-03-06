package no.kebabproffen.controllers;

import java.util.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import no.kebabproffen.models.DAO.CommentDAO;
import no.kebabproffen.models.DTO.CommentDTO;
import no.kebabproffen.repositories.CommentRepository;



@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentRepository repository;

    public CommentController(CommentRepository repository){
        this.repository = repository;
    }

    @GetMapping(value="/")
    public List<CommentDTO> getComments() {
        return repository.findAll().stream().map(CommentDAO::toDTO).toList();
    }

    @PostMapping(value = "/")
    CommentDTO createComment(@RequestBody CommentDTO comment){
        return repository.save(comment.toDAO()).toDTO();
    }
    
    @GetMapping(value = "/{commentId}")
    CommentDTO getComment(@PathVariable UUID commentId){
        return repository.getById(commentId).toDTO();
    }

    @DeleteMapping(value = "/{commentId}")
    void deleteComment(@PathVariable UUID commentId){
        repository.deleteById(commentId);
    }
    
}
