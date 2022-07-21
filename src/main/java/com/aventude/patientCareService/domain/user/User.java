package com.aventude.patientCareService.domain.user;

import com.aventude.patientCareService.domain.PersonalInformation;
import com.aventude.patientCareService.domain.role.Role;
import com.aventude.patientCareService.platform.common.PasswordEncoderConverter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * The type User.
 */
@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends PersonalInformation {

    @NotBlank
    @Column(name = "username", unique = true)
    private String userName;

    @Column(updatable = false, name = "password", columnDefinition = "text NOT NULL")
    @Convert(converter = PasswordEncoderConverter.class)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "enabled", columnDefinition = "boolean NOT NULL DEFAULT false")
    private boolean enabled;

    @OneToOne
    @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "role_fk"))
    @NotNull
    private Role role;

    public User(String email, String password) {
        super();
        this.setUserName(email);
        this.setPassword(password);
    }
}
