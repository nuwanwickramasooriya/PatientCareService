package com.aventude.patientCareService.application.services;

import com.aventude.patientCareService.application.dto.PatientConsultationResponse;

import java.util.List;
import java.util.UUID;

/**
 * The interface Patient application service.
 */
public interface PatientApplicationService {
    /**
     * Find all patient consultation list.
     *
     * @param doctorId the doctor id
     * @return the list
     */
    List<PatientConsultationResponse> findAllPatientConsultation(UUID doctorId);

    /**
     * Find all patient consultation by patient list.
     *
     * @param patientId the patient id
     * @return the list
     */
    List<PatientConsultationResponse> findAllPatientConsultationByPatient(UUID patientId);
}
