package com.aventude.patientCareService.controller.user;

import com.aventude.patientCareService.application.dto.*;
import com.aventude.patientCareService.application.services.UserApplicationService;
import com.aventude.patientCareService.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Act as main controller for managing user's information.
 *
 * @author Nuwan Danushka
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserApplicationService applicationService;

    /**
     * serve createUser request and produce response entity along with
     * UserResponse and HttpStatus. This is responsible for executing create
     * user service.
     *
     * @param userCreateRequest user create request
     * @return ResponseEntity with UserCreateResponse and HttpStatus
     */
    @PostMapping
    public ResponseEntity createUser(@Valid @RequestBody UserCreateRequest userCreateRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(Optional
                .ofNullable(applicationService.createUser(
                        new User(userCreateRequest.getEmail(), userCreateRequest.getPassword())))
                .map(user -> new UserCreateResponse(user.getId(), user.getEmail(),
                        user.getCreatedDate(), user.getLastUpdatedDate(),
                        user.isEnabled())));
    }

    /**
     * Authenticate user by given user name and password and return bear token .
     *
     * @param request the user authentication request
     * @return UserAuthenticationResponse It contains bearer token
     * @throws Exception the exception
     */
    @PostMapping(value = "/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    UserAuthenticationResponse
    authenticateUser(@RequestBody UserAuthenticationRequest request) throws Exception {
        return applicationService
                .authentication(new User(request.getEmail(), request.getPassword()));
    }

    /**
     * verify token.
     *
     * @param request verify token request
     * @return VerifyTokenResponse It contains status of the token
     */
    @PostMapping(value = "/verifyToken", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    VerifyTokenResponse verifyToken(@RequestBody VerifyTokenRequest request) {
        return applicationService.verifyToken(request);
    }


}
