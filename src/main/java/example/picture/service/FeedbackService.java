package example.picture.service;

import example.picture.model.Feedback;
import example.picture.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository repository;

    public List<Feedback> getFeedbacksForToday() {
        return repository.findByDate(LocalDate.now());
    }

    public Feedback saveFeedback(Feedback feedback) {
        feedback.setDate(LocalDate.now());
        return repository.save(feedback);
    }

    public void likeFeedback(Long id) {
        Feedback feedback = repository.findById(id).orElseThrow(() -> new RuntimeException("Feedback not found"));
        feedback.setLikes(feedback.getLikes() + 1);
        repository.save(feedback);
    }
}