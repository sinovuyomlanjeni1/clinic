package com.clinic.controller;


import com.clinic.model.Appointment;
import com.clinic.service.AppointmentService;
import com.clinic.service.DoctorService;
import com.clinic.service.PatientService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;



@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final PatientService patientService;
    private final DoctorService doctorService;

    public AppointmentController(AppointmentService appointmentService,
                                 PatientService patientService,
                                 DoctorService doctorService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
        this.doctorService = doctorService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("appointments", appointmentService.getAllAppointments());
        return "appointments";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "appointment_form";
    }

    @PostMapping
    public String save(@RequestParam Long patientId,
                       @RequestParam Long doctorId,
                       @RequestParam("dateTime")
                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime,
                       Model model) {

        if (!appointmentService.isDoctorAvailable(doctorId, dateTime)) {
            model.addAttribute("error", "Doctor is already booked at this time.");
            model.addAttribute("patients", patientService.getAllPatients());
            model.addAttribute("doctors", doctorService.getAllDoctors());
            return "appointment_form";
        }

        Appointment appointment = new Appointment();
        appointment.setPatient(patientService.getPatientById(patientId));
        appointment.setDoctor(doctorService.getDoctorById(doctorId));
        appointment.setDateTime(dateTime);
        appointment.setStatus("BOOKED");

        appointmentService.saveAppointment(appointment);

        return "redirect:/appointments";
    }

    // EDIT FORM
    @GetMapping("/edit/{id}")
    public String editAppointment(@PathVariable Long id, Model model) {

        Appointment appointment = appointmentService.getAppointmentById(id);

        model.addAttribute("appointment", appointment);
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("doctors", doctorService.getAllDoctors());

        return "appointment_edit_form";
    }

    //  UPDATE APPOINTMENT
    @PostMapping("/update")
    public String updateAppointment(@RequestParam Long id,
                                    @RequestParam Long patientId,
                                    @RequestParam Long doctorId,
                                    @RequestParam("dateTime")
                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime,
                                    @RequestParam String status,
                                    Model model) {

        Appointment appointment = appointmentService.getAppointmentById(id);

        if (appointment == null) {
            return "redirect:/appointments";
        }

        if (!appointment.getDoctor().getId().equals(doctorId)
                || !appointment.getDateTime().equals(dateTime)) {

            if (!appointmentService.isDoctorAvailable(doctorId, dateTime)) {
                model.addAttribute("error", "Doctor is already booked at this time.");
                model.addAttribute("appointment", appointment);
                model.addAttribute("patients", patientService.getAllPatients());
                model.addAttribute("doctors", doctorService.getAllDoctors());
                return "appointment_edit_form";
            }
        }

        appointment.setPatient(patientService.getPatientById(patientId));
        appointment.setDoctor(doctorService.getDoctorById(doctorId));
        appointment.setDateTime(dateTime);
        appointment.setStatus(status);

        appointmentService.saveAppointment(appointment);

        return "redirect:/appointments";
    }

    // CANCEL APPOINTMENT (change status instead of delete)
    @GetMapping("/cancel/{id}")
    public String cancel(@PathVariable Long id) {

        Appointment appointment = appointmentService.getAppointmentById(id);

        if (appointment != null) {
            appointment.setStatus("CANCELLED");
            appointmentService.saveAppointment(appointment);
        }

        return "redirect:/appointments";
    }

}
