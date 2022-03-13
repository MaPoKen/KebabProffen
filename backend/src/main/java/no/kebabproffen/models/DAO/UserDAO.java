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

    @Column(unique = true, nullable = false)
    private String username;
    
    @Column(nullable = false)
    private String password;
    
    @Column(unique = true, nullable = false)
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    private RoleDAO role;

    public UserDAO(String username, String password, String email, RoleDAO role){
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
    
    public UserDAO(UUID userId, String username, String password, String email, RoleDAO role){
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.userId = userId;
    }

    public UserDAO(){}


    @Override
    public UserDTO toDTO() {
        return new UserDTO(userId, username, password, email, role.toDTO());
    }

}