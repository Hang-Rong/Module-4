package example.picture.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name="pictures")
public class Feedback {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;
    private int rating;
    private String comment;
    private LocalDate date;
    private int likes = 0;

    public Feedback() {
    }

    public Feedback(Long id, String author, int rating, String comment, LocalDate date, int likes) {
        this.id = id;
        this.author = author;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
        this.likes = likes;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
