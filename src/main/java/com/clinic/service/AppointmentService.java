package com.clinic.service;

import com.clinic.model.Appointment;
import com.clinic.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository repository;

    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    public List<Appointment> getAllAppointments() {
        return repository.findAll();
    }

    public Appointment saveAppointment(Appointment appointment) {
        return repository.save(appointment);
    }

    public Appointment getAppointmentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteAppointment(Long id) {
        repository.deleteById(id);
    }

    public boolean isDoctorAvailable(Long doctorId, LocalDateTime dateTime) {
        return repository
                .findByDoctorIdAndDateTime(doctorId, dateTime)
                .isEmpty();
    }
}
