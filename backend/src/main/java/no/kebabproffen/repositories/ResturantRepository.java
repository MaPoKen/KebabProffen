package no.kebabproffen.repositories;

import no.kebabproffen.models.Resturant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ResturantRepository extends JpaRepository<Resturant, UUID> {
    
}
