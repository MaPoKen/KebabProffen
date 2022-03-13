package no.kebabproffen.models.DAO;

import javax.persistence.*;

import no.kebabproffen.models.DAOInterface;
import no.kebabproffen.models.DTO.CommentDTO;

import java.time.LocalDateTime;  
import java.util.*;

@Entity
@Table(name="comment")
public class CommentDAO implements DAOInterface<CommentDTO>{

    @Id
    @GeneratedValue
    private UUID commentId;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDAO user;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private ReviewDAO review;

    private String comment;

    private LocalDateTime created;

    private LocalDateTime edited;

    public CommentDAO(UUID commentId, UserDAO user, String comment, LocalDateTime created, LocalDateTime edited, ReviewDAO review){
        this.commentId = commentId;
        this.user = user;
        this.comment = comment;
        this.created = created;
        this.edited = edited;
        this.review = review;
    }

    public CommentDAO(){}

    @Override
    public CommentDTO toDTO() {
        return new CommentDTO(commentId,user.toDTO(),comment,created,edited,review.toDTO());
    };

}