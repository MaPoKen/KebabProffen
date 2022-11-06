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
    private final UUID commentId;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private final UserDAO user;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private final ReviewDAO review;

    private final String comment;

    private final LocalDateTime created;

    private final LocalDateTime edited;

    public CommentDAO(UUID commentId, UserDAO user, String comment, LocalDateTime created, LocalDateTime edited, ReviewDAO review){
        this.commentId = commentId;
        this.user = user;
        this.comment = comment;
        this.created = created;
        this.edited = edited;
        this.review = review;
    }

    @Override
    public CommentDTO toDTO() {
        return new CommentDTO(commentId,user.toDTO(),comment,created,edited,review.toDTO());
    };

}