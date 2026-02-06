package com.clinic.controller;


import com.clinic.model.Patient;
import com.clinic.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patients")
public class PatientController {

    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @GetMapping
    public String listPatients(Model model) {
        model.addAttribute("patients", service.getAllPatients());
        return "patients";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patientform";
    }

    @PostMapping
    public String save(@ModelAttribute Patient patient) {
        service.savePatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("patient", service.getPatientById(id));
        return "patientform";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deletePatient(id);
        return "redirect:/patients";
    }
}
