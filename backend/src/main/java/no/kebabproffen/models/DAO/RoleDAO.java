package no.kebabproffen.models.DAO;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import no.kebabproffen.models.DAOInterface;
import no.kebabproffen.models.DTO.RoleDTO;
import no.kebabproffen.models.enums.Role;

@Entity
@Table(name="roles")
public class RoleDAO implements DAOInterface<RoleDTO> {
    
    @Id
    @GeneratedValue
    @Column(name = "roleid", updatable = false, nullable = false)
    public UUID roleId;

    @Enumerated(EnumType.ORDINAL) 
    private Role role;


    public RoleDAO(Role role){
        this.role = role;
    }

    @Override
    public RoleDTO toDTO() {
        return new RoleDTO(role);
    }

    
    
}
