package com.aventude.patientCareService.controller.patient;

import com.aventude.patientCareService.application.services.PatientApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientApplicationService applicationService;

    @GetMapping("/{doctorId}")
    @PreAuthorize("hasRole('DOCTOR', 'ADMIN')")
    public ResponseEntity findAllPatientConsultation(@PathVariable(required = true) UUID doctorId){
        return ResponseEntity.status(HttpStatus.CREATED).body(Optional
                .ofNullable(applicationService.findAllPatientConsultation(
                        doctorId)));
    }

    @GetMapping("/{patientId}")
    @PreAuthorize("hasPermission('PATIENT_STATUS', 'CAN_ACCESS_CONSULTATION') and hasRole('PATIENT')")
    public ResponseEntity findAllPatientConsultationByPatient(@PathVariable(required = true) UUID patientId){
        return ResponseEntity.status(HttpStatus.CREATED).body(Optional
                .ofNullable(applicationService.findAllPatientConsultationByPatient(
                        patientId)));
    }
}
