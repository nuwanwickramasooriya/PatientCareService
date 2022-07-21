/**
 *
 */
package com.aventude.patientCareService.platform.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * The Password encoder converter.
 */
@Converter
public class PasswordEncoderConverter implements AttributeConverter<String, String> {

    /**
     * The Password encoder.
     */
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public String convertToDatabaseColumn(String rawPassword) {
        passwordEncoder = new BCryptPasswordEncoder();
        if (rawPassword != null)
            return passwordEncoder.encode(rawPassword);
        return null;
    }

    @Override
    public String convertToEntityAttribute(String password) {
        return password;
    }

}
