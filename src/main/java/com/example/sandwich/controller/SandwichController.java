package com.example.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sandwich")
public class SandwichController {

    @RequestMapping("/")
    public String showForm() {
        return "form";
    }

    @RequestMapping("/save")
    public String save(@RequestParam(value = "condiment", required = false) String[] condiments, Model model) {
        if (condiments != null && condiments.length > 0) {
            model.addAttribute("selectedCondiments", condiments);
        } else {
            model.addAttribute("selectedCondiments", new String[]{});
        }
        return "result";
    }
}
