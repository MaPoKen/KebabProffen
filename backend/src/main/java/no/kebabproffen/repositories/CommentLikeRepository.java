package no.kebabproffen.repositories;

import no.kebabproffen.models.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CommentLikeRepository extends JpaRepository<CommentLike, UUID> {
    
}
