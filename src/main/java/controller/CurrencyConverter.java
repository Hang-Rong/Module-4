package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConverter{

    @GetMapping("/")
    public String showForm() {
        return "converter";
    }

    @PostMapping("/convert")
    public String convertCurrency(@RequestParam("rate") double rate,
                                  @RequestParam("usdAmount") double usdAmount,
                                  Model model) {
        double vndAmount = rate * usdAmount;
        model.addAttribute("usdAmount", usdAmount);
        model.addAttribute("rate", rate);
        model.addAttribute("vndAmount", vndAmount);
        return "result";
    }
}
