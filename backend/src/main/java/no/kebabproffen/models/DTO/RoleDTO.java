package no.kebabproffen.models.DTO;

import no.kebabproffen.models.DTOInterface;
import no.kebabproffen.models.DAO.RoleDAO;
import no.kebabproffen.models.enums.Role;

public class RoleDTO implements DTOInterface<RoleDAO> {
    
    private Role role;

    public RoleDTO(Role role){
        this.role = role;
    }

    public RoleDTO(){}

    public Role getRole(){
        return role;
    }

    @Override
    public RoleDAO toDAO() {
        return new RoleDAO(role);
    }
    
}
