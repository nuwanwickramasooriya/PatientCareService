package com.aventude.patientCareService.application.services;

import com.aventude.patientCareService.application.dto.UserAuthenticationResponse;
import com.aventude.patientCareService.application.dto.VerifyTokenRequest;
import com.aventude.patientCareService.application.dto.VerifyTokenResponse;
import com.aventude.patientCareService.domain.user.User;

public interface UserApplicationService {
    User createUser(User user);

    UserAuthenticationResponse authentication(User user);

    VerifyTokenResponse verifyToken(VerifyTokenRequest request);
}
