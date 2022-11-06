package no.kebabproffen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import no.kebabproffen.models.DAO.ResturantDAO;

import java.util.UUID;

public interface ResturantRepository extends JpaRepository<ResturantDAO, UUID> {
    
}
