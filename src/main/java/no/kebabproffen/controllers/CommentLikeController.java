package no.kebabproffen.controllers;

import java.util.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import no.kebabproffen.models.DAO.CommentLikeDAO;
import no.kebabproffen.models.DTO.CommentLikeDTO;
import no.kebabproffen.repositories.CommentLikeRepository;



@RestController
@RequestMapping("/api/like/comment")
public class CommentLikeController {

    private final CommentLikeRepository repository;

    public CommentLikeController(CommentLikeRepository repository){
        this.repository = repository;
    }

    @GetMapping(value="/")
    public List<CommentLikeDTO> getCommentLikes() {
        return repository.findAll().stream().map(CommentLikeDAO::toDTO).toList();
    }

    @PostMapping(value = "/")
    CommentLikeDTO createCommentLike(@RequestBody CommentLikeDTO commentLike){
        return repository.save(commentLike.toDAO()).toDTO();
    }
    
    @GetMapping(value = "/{commentLikeId}")
    CommentLikeDTO getCommentLike(@PathVariable UUID commentLikeId){
        return repository.getById(commentLikeId).toDTO();
    }

    @DeleteMapping(value = "/{commentLikeId}")
    void deleteCommentLike(@PathVariable UUID commentLikeId){
        repository.deleteById(commentLikeId);
    }
    
}
