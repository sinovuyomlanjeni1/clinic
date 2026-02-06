package com.clinic.repository;

import com.clinic.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Optional<Appointment> findByDoctorIdAndDateTime(
            Long doctorId,
            LocalDateTime dateTime
    );
}
