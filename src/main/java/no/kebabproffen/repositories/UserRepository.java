package no.kebabproffen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import no.kebabproffen.models.DAO.UserDAO;

import java.util.UUID;
// JpaRepository<Model, ID type>
public interface UserRepository extends JpaRepository<UserDAO, UUID> {

}