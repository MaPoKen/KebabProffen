package no.kebabproffen.models.DAO;

import javax.persistence.*;

import no.kebabproffen.models.DAOInterface;
import no.kebabproffen.models.DTO.CommentLikeDTO;

import java.util.*;

@Entity
@Table(name="commentLike")
public class CommentLikeDAO extends LikeDAO implements DAOInterface<CommentLikeDTO>{

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private final CommentDAO comment;

    public CommentLikeDAO(UUID likeId, UserDAO user, int rating, CommentDAO comment){
        super(likeId, user, rating);
        this.comment = comment;
    }

    @Override
    public CommentLikeDTO toDTO() {
        return new CommentLikeDTO(likeId, user.toDTO(), rating, comment.toDTO());
    }
}