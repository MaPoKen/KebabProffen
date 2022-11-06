package no.kebabproffen.models.DAO;

import javax.persistence.*;

import no.kebabproffen.models.DAOInterface;
import no.kebabproffen.models.DTO.ReviewLikeDTO;

import java.util.*;

@Entity
@Table(name="reviewLike")
public class ReviewLikeDAO extends LikeDAO implements DAOInterface<ReviewLikeDTO>{
    

    @ManyToOne
    @JoinColumn(name = "review_id")
    private final ReviewDAO review;

    public ReviewLikeDAO(UUID likeId, UserDAO user, int rating, ReviewDAO review){
        super( likeId,  user,  rating);
        this.review = review;
    }

    @Override
    public ReviewLikeDTO toDTO() {
        return new ReviewLikeDTO(likeId, user.toDTO(), rating, review.toDTO());
    }
}