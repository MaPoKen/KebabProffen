package no.kebabproffen.models.DAO;

import javax.persistence.*;

import no.kebabproffen.models.DAOInterface;
import no.kebabproffen.models.DTO.ReviewDTO;

import java.util.*;

@Entity
@Table(name = "review")
public class ReviewDAO implements DAOInterface<ReviewDTO>{
    
    @Id
    @GeneratedValue
    @Column(name = "review_id")
    private UUID reviewId;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDAO user;

    @ManyToOne
    @JoinColumn(name = "resturant_id")
    private ResturantDAO resturant;
    
    private String title;
    
    private String review;
    
    private int rating;

    public ReviewDAO(UUID reviewId, UserDAO user, ResturantDAO resturant, String review, String title, int rating){
        this.reviewId = reviewId;
        this.user = user;
        this.resturant = resturant;
        this.review = review;
        this.rating = rating;
    }

    public ReviewDAO(){}

    @Override
    public ReviewDTO toDTO() {
        return new ReviewDTO(reviewId, user.toDTO(), resturant.toDTO(), review, title, rating);
    }

}