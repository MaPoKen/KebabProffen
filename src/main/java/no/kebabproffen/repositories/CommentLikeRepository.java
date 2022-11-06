package no.kebabproffen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import no.kebabproffen.models.DAO.CommentLikeDAO;

import java.util.UUID;

public interface CommentLikeRepository extends JpaRepository<CommentLikeDAO, UUID> {
    
}
