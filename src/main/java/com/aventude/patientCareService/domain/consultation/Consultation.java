package com.aventude.patientCareService.domain.consultation;

import com.aventude.patientCareService.domain.doctor.Doctor;
import com.aventude.patientCareService.domain.patient.Patient;
import com.aventude.patientCareService.platform.common.AuditableEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@Entity
@Table(name = "consultation")
public class Consultation extends AuditableEntity  {

    @NotBlank
    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "bloodPressure")
    private String bloodPressure;

    @OneToOne
    @JoinColumn(name = "doctor_id", foreignKey = @ForeignKey(name = "doctor_fk"))
    @NotNull
    private Doctor doctor;

    @OneToOne
    @JoinColumn(name = "patient_id", foreignKey = @ForeignKey(name = "patient_fk"))
    @NotNull
    private Patient patient;
}
