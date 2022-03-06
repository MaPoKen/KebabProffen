package no.kebabproffen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import no.kebabproffen.models.DAO.ReviewLikeDAO;

import java.util.UUID;

public interface ReviewLikeRepository extends JpaRepository<ReviewLikeDAO, UUID> {
    
}
