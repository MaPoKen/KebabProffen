package no.kebabproffen.repositories;

import no.kebabproffen.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
// JpaRepository<Model, ID type>
public interface LocationRepository extends JpaRepository<Location, UUID> {

}