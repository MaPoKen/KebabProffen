package no.kebabproffen.repositories;

import no.kebabproffen.models.ReviewLike;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ReviewLikeRepository extends JpaRepository<ReviewLike, UUID> {
    
}
