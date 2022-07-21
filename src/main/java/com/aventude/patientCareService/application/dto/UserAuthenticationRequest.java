package com.aventude.patientCareService.application.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Request object of authentication end point.
 *
 * @author Nuwan Danushka
 */

@Getter
@Setter
public class UserAuthenticationRequest {
    // email of the login user.
    private String email;
    // password of the login user.
    private String password;
}
