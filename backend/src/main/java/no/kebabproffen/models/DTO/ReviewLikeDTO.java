package no.kebabproffen.models.DTO;

import javax.persistence.*;

import no.kebabproffen.models.DTOInterface;
import no.kebabproffen.models.DAO.ReviewLikeDAO;

import java.util.*;

public class ReviewLikeDTO extends LikeDTO implements DTOInterface<ReviewLikeDAO> {
    
    private ReviewDTO review;

    public ReviewLikeDTO(UUID likeId, UserDTO user, int rating, ReviewDTO review){
        super( likeId,  user,  rating);
        this.review = review;
    }

    @Override
    public ReviewLikeDAO toDAO() {
        return new ReviewLikeDAO(likeId, user.toDAO(), rating, review.toDAO());
    }
}