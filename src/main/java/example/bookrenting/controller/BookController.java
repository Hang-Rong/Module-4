package example.bookrenting.controller;

import example.bookrenting.model.Book;
import example.bookrenting.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "index";
    }

    @GetMapping("/borrow")
    public String showBorrowPage() {
        return "borrow";
    }

    @PostMapping("/borrow")
    public String borrowBook(@RequestParam String bookCode, Model model) {
        try {
            bookService.borrowBook(bookCode);
            model.addAttribute("message", "Book borrowed successfully!");
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "borrow";
    }

    @GetMapping("/return")
    public String showReturnPage() {
        return "return";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam String bookCode, Model model) {
        try {
            bookService.returnBook(bookCode);
            model.addAttribute("message", "Book returned successfully!");
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "return";
    }
}