package no.kebabproffen.repositories;

import no.kebabproffen.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review, UUID> {
    
}
