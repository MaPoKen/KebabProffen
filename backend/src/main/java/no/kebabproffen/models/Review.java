package no.kebabproffen.models;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "review")
public class Review {
    
    @Id
    @GeneratedValue
    @Column(name = "review_id")
    private UUID reviewId;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "resturant_id")
    private Resturant resturant;
    
    private String title;
    
    private String review;
    
    private int rating;

    public Review(UUID reviewId, User user, Resturant resturant, String review, String title, int rating){
        this.reviewId = reviewId;
        this.user = user;
        this.resturant = resturant;
        this.review = review;
        this.rating = rating;
    }

    

}