package com.aventude.patientCareService.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class UserCreateResponse {

    private UUID id;

    private String email;

    private DateTime createdDate;

    private DateTime lastUpdatedDate;

    private boolean enabled;

}
