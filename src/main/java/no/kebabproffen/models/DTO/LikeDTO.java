package no.kebabproffen.models.DTO;

import java.util.UUID;


public abstract class LikeDTO {

    protected final UUID likeId;
    protected UserDTO user;
    protected int rating;

    public LikeDTO(UUID likeId, UserDTO user, int rating){
        this.likeId = likeId;
        this.rating = rating;
        this.user = user;
    }
}