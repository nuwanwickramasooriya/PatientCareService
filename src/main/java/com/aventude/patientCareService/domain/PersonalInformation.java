package com.aventude.patientCareService.domain;

import com.aventude.patientCareService.platform.common.AuditableEntity;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;
import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
public class PersonalInformation extends AuditableEntity implements Serializable {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "date_of_birth")
    private DateTime dateOfBirth;

}
