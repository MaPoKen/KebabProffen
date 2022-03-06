package no.kebabproffen.models;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="commentLike")
public class CommentLike extends Like {
    

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private final Comment comment;

    public CommentLike(UUID likeId, User user, int rating, Comment comment){
        super( likeId,  user,  rating);
        this.comment = comment;
    }
}