package no.kebabproffen.models.DTO;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import no.kebabproffen.models.DTOInterface;
import no.kebabproffen.models.DAO.RoleDAO;
import no.kebabproffen.models.enums.Role;

public class RoleDTO implements DTOInterface<RoleDAO> {
    
    private final Role role;

    public RoleDTO(Role role){
        this.role = role;
    }

    @Override
    public RoleDAO toDAO() {
        return new RoleDAO(role);
    }
    
}
