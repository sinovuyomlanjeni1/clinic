package com.clinic.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String specialization;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    //Constructor
    public Doctor() {}

    //Getters
    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getSpecialization(){
        return specialization;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    //Setters


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
