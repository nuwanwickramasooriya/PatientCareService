package com.aventude.patientCareService.domain.role;

import com.aventude.patientCareService.platform.common.AuditableEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Application level roles .
 */
@Getter
@Setter
@Entity
@Table(name = "role")
public class Role extends AuditableEntity implements Serializable {

    @Column(name = "roleName")
    private String roleName;

    @Column(name = "enabled", columnDefinition = "boolean NOT NULL DEFAULT false")
    private boolean enabled;

    @OneToMany
    @JoinColumn(name = "role_permission", foreignKey = @ForeignKey(name = "role_permission_fk"))
    private List<RolePermission> rolePermissionList;

}
