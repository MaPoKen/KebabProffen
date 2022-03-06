package no.kebabproffen.models;

import javax.persistence.Table;
import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name="likes")
public abstract class Like {

    @Id
    @GeneratedValue
    private final UUID likeId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    private int rating;

    public Like(UUID likeId, User user, int rating){
        this.likeId = likeId;
        this.rating = rating;
        this.user = user;
    }
}