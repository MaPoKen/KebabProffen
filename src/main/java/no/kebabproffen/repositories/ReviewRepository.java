package no.kebabproffen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import no.kebabproffen.models.DAO.ReviewDAO;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<ReviewDAO, UUID> {
    
}
