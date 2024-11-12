package com.example.luutrumail.controller;

import com.example.luutrumail.model.HealthDeclarationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/healthDeclaration")
public class HealthDeclarationController {


    @RequestMapping("/form")
    public String showForm() {
        return "declarationForm";
    }

    @PostMapping("/submit")
    public String submitForm(HealthDeclarationForm healthDeclarationForm, Model model) {
        model.addAttribute("healthDeclarationForm", healthDeclarationForm);
        return "confirmation";
    }
}