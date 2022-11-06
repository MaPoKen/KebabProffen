package no.kebabproffen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import no.kebabproffen.models.DAO.LocationDAO;

import java.util.UUID;
// JpaRepository<Model, ID type>
public interface LocationRepository extends JpaRepository<LocationDAO, UUID> {

}