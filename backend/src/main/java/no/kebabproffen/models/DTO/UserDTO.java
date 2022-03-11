package no.kebabproffen.models.DTO;
import java.util.UUID;

import no.kebabproffen.models.DTOInterface;
import no.kebabproffen.models.DAO.UserDAO;

public class UserDTO implements DTOInterface<UserDAO> {

    private UUID userId;
    private String username;
    private String password;
    private String email;
    private RoleDTO role;

    public UserDTO(String username, String password, String email, RoleDTO role){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public UserDTO(UUID userId, String username, String password, String email){
        this.userId = userId;
        this.username = username;
        this.password = password;
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

    public String getPassword(){
        return password;
    }

    public String getEmail(){
        return email;
    }

    @Override
    public UserDAO toDAO() {
        return new UserDAO(username, password, email, role.toDAO());
    }

}