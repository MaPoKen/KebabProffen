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

    public UserDAO(String username, String hashedPassword, String email){
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.email = email;
    }

    public UUID getUserId(){
        return userId;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String newName){
        username=newName;
    }

    public String getHashedPassword(){
        return hashedPassword;
    }

    public void setHashedPassword(String password){
        hashedPassword = password;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String newEmail){
        email = newEmail;
    }

    @Override
    public UserDTO toDTO() {
        return new UserDTO(username, hashedPassword, email);
    }

}