package no.kebabproffen.models.DAO;

import javax.persistence.Table;
import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name="likes")
public abstract class LikeDAO {

    @Id
    @GeneratedValue
    protected
    final UUID likeId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    protected UserDAO user;
    
    protected int rating;

    public LikeDAO(UUID likeId, UserDAO user, int rating){
        this.likeId = likeId;
        this.rating = rating;
        this.user = user;
    }
}