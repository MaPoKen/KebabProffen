package no.kebabproffen.models.DAO;

import java.util.UUID;
import javax.persistence.*;

@Entity
@DiscriminatorColumn(name="REF_LIKE")
public abstract class LikeDAO {

    @Id
    @GeneratedValue
    protected UUID likeId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    protected UserDAO user;
    
    protected int rating;

    public LikeDAO(UUID likeId, UserDAO user, int rating){
        this.likeId = likeId;
        this.rating = rating;
        this.user = user;
    }

    public LikeDAO(){}
}