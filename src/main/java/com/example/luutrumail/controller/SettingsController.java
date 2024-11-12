package com.example.luutrumail.controller;

import com.example.luutrumail.model.EmailSettings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/settings")
public class SettingsController {

    private EmailSettings settings = new EmailSettings();

    public SettingsController() {
        settings.setLanguage("English");
        settings.setPageSize(25);
        settings.setSpamFilterEnabled(false);
        settings.setSignature("Thor\nKing, Asgard");
    }

    @GetMapping("/get")
    public String showSettingsForm(Model model) {
        model.addAttribute("settings", settings);
        return "settings";
    }

    @PostMapping("/post")
    public String updateSettings(@ModelAttribute("settings") EmailSettings updatedSettings) {
        this.settings = updatedSettings;
        return "redirect:/settings";
    }
}