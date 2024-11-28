package example.bookrenting.repository;

import example.bookrenting.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByCode(String code);
}
