package com.aventude.patientCareService.application.dto;

public enum RoleType {

    DOCTOR("doctor"),
    PATIENT("patient"),
    ADMIN("admin");

    private String displayName;

    RoleType(String displayName){
        this.displayName = displayName;
    }
}
