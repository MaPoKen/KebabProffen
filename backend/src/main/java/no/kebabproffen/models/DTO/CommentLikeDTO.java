package no.kebabproffen.models.DTO;

import java.util.*;

import no.kebabproffen.models.DTOInterface;
import no.kebabproffen.models.DAO.CommentLikeDAO;

public class CommentLikeDTO extends LikeDTO implements DTOInterface<CommentLikeDAO>{
    
    private CommentDTO comment;

    public CommentLikeDTO(UUID likeId, UserDTO user, int rating, CommentDTO comment){
        super( likeId,  user,  rating);
        this.comment = comment;
    }

    @Override
    public CommentLikeDAO toDAO() {
        return new CommentLikeDAO(likeId, user.toDAO(), rating, comment.toDAO());
    }
}