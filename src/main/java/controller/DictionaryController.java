package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {

    private static final Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("world", "thế giới");
        dictionary.put("computer", "máy tính");
        dictionary.put("java", "ngôn ngữ lập trình Java");
    }

    @GetMapping("/")
    public String showForm() {
        return "search";
    }

    @GetMapping("/search")
    public String searchWord(@RequestParam("word") String word, Model model) {
        String meaning = dictionary.get(word.toLowerCase());
        if (meaning != null) {
            model.addAttribute("word", word);
            model.addAttribute("meaning", meaning);
        } else {
            model.addAttribute("word", word);
            model.addAttribute("meaning", "Not found.");
        }
        return "result";
    }
}

