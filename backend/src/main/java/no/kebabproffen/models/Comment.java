package no.kebabproffen.models;

import javax.persistence.*;
import java.time.LocalDateTime;  
import java.util.*;

@Entity
@Table(name="comment")
public class Comment {

    @Id
    @GeneratedValue
    private final int commentId;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private final User user;

    @ManyToOne
    @JoinColumn(name = "resturant_id")
    private final Resturant resturant;

    private final String comment;

    private final LocalDateTime created;

    private final LocalDateTime edited;


    public Comment(int commentId, User user, String comment, LocalDateTime created, LocalDateTime edited, Resturant resturant){
        this.commentId = commentId;
        this.user = user;
        this.comment = comment;
        this.created = created;
        this.edited = edited;
        this.resturant = resturant;
    };

}