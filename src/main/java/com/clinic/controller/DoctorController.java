package com.clinic.controller;

import com.clinic.model.Doctor;
import com.clinic.service.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @GetMapping
    public String listDoctors(Model model) {
        model.addAttribute("doctors", service.getAllDoctors());
        return "doctors";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctorform";
    }

    @PostMapping
    public String save(@ModelAttribute Doctor doctor) {
        service.saveDoctor(doctor);
        return "redirect:/doctors";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("doctor", service.getDoctorById(id));
        return "doctorform";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteDoctor(id);
        return "redirect:/doctors";
    }
}
