package no.kebabproffen.models;

import javax.persistence.*;
import java.time.LocalDateTime;  
import java.util.*;

@Entity
@Table(name="comment")
public class Comment {

    @Id
    @GeneratedValue
    private final UUID commentId;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private final User user;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private final Review review;

    private final String comment;

    private final LocalDateTime created;

    private final LocalDateTime edited;


    public Comment(UUID commentId, User user, String comment, LocalDateTime created, LocalDateTime edited, Review review){
        this.commentId = commentId;
        this.user = user;
        this.comment = comment;
        this.created = created;
        this.edited = edited;
        this.review = review;
    };

}