package com.aventude.patientCareService.domain.patient;

import com.aventude.patientCareService.domain.PersonalInformation;
import com.aventude.patientCareService.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The Patient information.
 */
@Getter
@Setter
@Entity
@Table(name = "patient")
public class Patient extends PersonalInformation {

    @OneToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_fk"))
    private User user;
}
