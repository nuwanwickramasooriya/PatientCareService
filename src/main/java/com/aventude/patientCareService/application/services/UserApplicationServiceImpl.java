package com.aventude.patientCareService.application.services;

import com.aventude.patientCareService.application.dto.UserAuthenticationResponse;
import com.aventude.patientCareService.application.dto.VerifyTokenRequest;
import com.aventude.patientCareService.application.dto.VerifyTokenResponse;
import com.aventude.patientCareService.domain.user.User;
import org.springframework.stereotype.Service;

@Service
public class UserApplicationServiceImpl implements UserApplicationService{
    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public UserAuthenticationResponse authentication(User user) {
        return null;
    }

    @Override
    public VerifyTokenResponse verifyToken(VerifyTokenRequest request) {
        return null;
    }
}
