package no.kebabproffen.models.DAO;
import javax.persistence.*;

import no.kebabproffen.models.DAOInterface;
import no.kebabproffen.models.DTO.UserDTO;

import java.util.UUID;

@Entity
@Table(name = "users")
public class UserDAO implements DAOInterface<UserDTO>{

    @Id
    @GeneratedValue
    @Column(name = "userid", updatable = false, nullable = false)
    private UUID userId;

    @Column(unique = true)
    private String username;

    private String hashedPassword;
    
    @Column(unique = true)
    private String email;

    @ManyToOne
    private RoleDAO role;

    public UserDAO(String username, String hashedPassword, String email, RoleDAO role){
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.email = email;
        this.role = role;
    }


    @Override
    public UserDTO toDTO() {
        return new UserDTO(username, hashedPassword, email, role.toDTO());
    }

}