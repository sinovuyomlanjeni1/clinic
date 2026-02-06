package com.clinic.service;

import com.clinic.model.Patient;
import com.clinic.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository repository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    public List<Patient> getAllPatients() {
        return repository.findAll();
    }

    public Patient savePatient(Patient patient) {
        return repository.save(patient);
    }

    public Patient getPatientById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletePatient(Long id) {
        repository.deleteById(id);
    }
}
