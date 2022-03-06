package no.kebabproffen.models;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="reviewLike")
public class ReviewLike extends Like {
    

    @ManyToOne
    @JoinColumn(name = "review_id")
    private final Review review;

    public ReviewLike(UUID likeId, User user, int rating, Review review){
        super( likeId,  user,  rating);
        this.review = review;
    }
}