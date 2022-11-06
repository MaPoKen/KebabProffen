package no.kebabproffen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import no.kebabproffen.models.DAO.CommentDAO;

import java.util.UUID;

public interface CommentRepository extends JpaRepository<CommentDAO, UUID> {
    
}
