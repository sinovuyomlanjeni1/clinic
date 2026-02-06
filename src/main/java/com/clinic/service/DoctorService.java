package com.clinic.service;

import com.clinic.model.Doctor;
import com.clinic.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository repository;

    public DoctorService(DoctorRepository repository) {
        this.repository = repository;
    }

    public List<Doctor> getAllDoctors() {
        return repository.findAll();
    }

    public Doctor saveDoctor(Doctor doctor) {
        return repository.save(doctor);
    }

    public Doctor getDoctorById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteDoctor(Long id) {
        repository.deleteById(id);
    }
}
