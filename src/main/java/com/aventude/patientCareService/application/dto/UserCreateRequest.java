package com.aventude.patientCareService.application.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class UserCreateRequest {
    @Email(message = "Email should be a valid email")
    @NotEmpty(message = "User Name must not be empty")
    private String email;
    @NotEmpty(message = "password must not be empty")
    private String password;

    private RoleType roleType;


}
