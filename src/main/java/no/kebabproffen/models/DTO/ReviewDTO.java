package no.kebabproffen.models.DTO;

import java.util.*;

import no.kebabproffen.models.DTOInterface;
import no.kebabproffen.models.DAO.ReviewDAO;

public class ReviewDTO implements DTOInterface<ReviewDAO>{
    
    private UUID reviewId;
    private UserDTO user;
    private ResturantDTO resturant;
    private String title;
    private String review;
    private int rating;

    public ReviewDTO(UUID reviewId, UserDTO user, ResturantDTO resturant, String review, String title, int rating){
        this.reviewId = reviewId;
        this.user = user;
        this.resturant = resturant;
        this.review = review;
        this.rating = rating;
    }

    @Override
    public ReviewDAO toDAO() {
        return new ReviewDAO(reviewId, user.toDAO(), resturant.toDAO(), review, title, rating);
    }

    

}