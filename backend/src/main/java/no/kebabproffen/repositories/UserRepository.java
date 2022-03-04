package no.kebabproffen.repositories;

import no.kebabproffen.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
// JpaRepository<Model, ID type>
public interface UserRepository extends JpaRepository<User, UUID> {

}