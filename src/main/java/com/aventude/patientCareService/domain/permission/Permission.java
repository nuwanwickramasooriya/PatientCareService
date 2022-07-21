package com.aventude.patientCareService.domain.permission;

import com.aventude.patientCareService.platform.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The type Permission.
 */
@Getter
@Setter
@Entity
@Table(name = "permission")
public class Permission extends BaseEntity {

    @Column(name = "actionType")
    private String actionType;

    @Column(name = "enabled", columnDefinition = "boolean NOT NULL DEFAULT false")
    private boolean enabled;
}
