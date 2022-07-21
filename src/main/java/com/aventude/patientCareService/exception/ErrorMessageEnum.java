package com.aventude.patientCareService.exception;

/**
 * The enum Error message enum.
 */
public enum ErrorMessageEnum {
    /**
     * The User exception.
     */
    USER_EXCEPTION("User Exception");

    /**
     * The Message.
     */
    public String message;

    ErrorMessageEnum(String message) {
        this.message = message;
    }
}
