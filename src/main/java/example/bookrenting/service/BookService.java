package example.bookrenting.service;

import example.bookrenting.exception.BookNotFoundException;
import example.bookrenting.model.Book;
import example.bookrenting.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void returnBook(String bookCode) {
        Book book = bookRepository.findByCode(bookCode);
        if (book == null) {
            throw new BookNotFoundException("Invalid book code: " + bookCode);
        }
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
    }

    public void borrowBook(String bookCode) {
        Book book = bookRepository.findByCode(bookCode);
        if (book == null || book.getQuantity() == 0) {
            throw new IllegalStateException("Book not available for borrowing.");
        }
        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);
    }
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
