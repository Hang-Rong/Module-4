package example.picture.controller;

import example.picture.model.Feedback;
import example.picture.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {
    @Autowired
    private FeedbackService service;

    @GetMapping
    public List<Feedback> getFeedbacks() {
        return service.getFeedbacksForToday();
    }

    @PostMapping
    public Feedback addFeedback(@RequestBody Feedback feedback) {
        return service.saveFeedback(feedback);
    }

    @PostMapping("/{id}/like")
    public void likeFeedback(@PathVariable Long id) {
        service.likeFeedback(id);
    }
}
