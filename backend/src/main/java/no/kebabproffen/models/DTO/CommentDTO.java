package no.kebabproffen.models.DTO;

import java.time.LocalDateTime;  
import java.util.*;

import javax.xml.stream.events.Comment;

import no.kebabproffen.models.DTOInterface;
import no.kebabproffen.models.DAO.CommentDAO;
import no.kebabproffen.models.DAO.ReviewDAO;
import no.kebabproffen.models.DAO.UserDAO;

public class CommentDTO implements DTOInterface<CommentDAO>{

    private UUID commentId;
    private UserDTO user;
    private ReviewDTO review;
    private String comment;
    private LocalDateTime created;
    private LocalDateTime edited;


    public CommentDTO(UUID commentId, UserDTO user, String comment, LocalDateTime created, LocalDateTime edited, ReviewDTO review){
        this.commentId = commentId;
        this.user = user;
        this.comment = comment;
        this.created = created;
        this.edited = edited;
        this.review = review;
    };

    public CommentDTO(UserDTO user, String comment, LocalDateTime created, LocalDateTime edited, ReviewDTO review){
        this.user = user;
        this.comment = comment;
        this.created = created;
        this.edited = edited;
        this.review = review;
    }

    @Override
    public CommentDAO toDAO() {
        return new CommentDAO(commentId, user.toDAO(), comment, created, edited, review.toDAO());
    };

}