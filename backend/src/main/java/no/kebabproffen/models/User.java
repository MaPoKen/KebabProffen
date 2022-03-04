package no.kebabproffen.models;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "userid", updatable = false, nullable = false)
    private UUID userId;

    @Column(unique = true)
    private String username;

    private String hashedPassword;
    
    @Column(unique = true)
    private String email;

    public User(){}

    public User(String username, String hashedPassword, String email){
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

}