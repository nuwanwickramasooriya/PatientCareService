package com.aventude.patientCareService.exception.enums;

import com.aventude.patientCareService.exception.ErrorMessageEnum;
import lombok.Getter;

@Getter
public class InvalidUserException extends RuntimeException {
    private String errorMessage;
    private ErrorMessageEnum errorMessageEnum;

    public InvalidUserException(ErrorMessageEnum errorMessageEnum) {
        this.errorMessageEnum = errorMessageEnum;
    }

    public InvalidUserException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }


}
