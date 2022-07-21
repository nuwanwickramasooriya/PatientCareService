package com.aventude.patientCareService.domain.role;

import com.aventude.patientCareService.domain.permission.Permission;
import com.aventude.patientCareService.platform.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The type Role permission.
 */
@Getter
@Setter
@Entity
@Table(name = "role_permission")
public class RolePermission extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "role_fk"))
    private Role role;

    @OneToOne
    @JoinColumn(name = "permission_id", foreignKey = @ForeignKey(name = "role_fk"))
    private Permission permission;

    @Column(name = "enabled", columnDefinition = "boolean NOT NULL DEFAULT false")
    private boolean enabled;
}
