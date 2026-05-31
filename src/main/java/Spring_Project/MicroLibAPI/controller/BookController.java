package Spring_Project.MicroLibAPI.controller;

import Spring_Project.MicroLibAPI.domain.Users;
import Spring_Project.MicroLibAPI.dto.books.BookCreateRequestDTO;
import Spring_Project.MicroLibAPI.dto.books.BookListResponseDTO;
import Spring_Project.MicroLibAPI.dto.users.UserResponseDTO;
import Spring_Project.MicroLibAPI.service.BookService;
import Spring_Project.MicroLibAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
    private UserService userService;
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService,  UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping("/books/new")
    public String createBookForm() {
        return "/books/createBookForm";
    }

    @PostMapping("/books/new")
    public String createBook(BookCreateRequestDTO request) {
        bookService.createBook(request);

        return "redirect:/books";
    }

    @GetMapping("/books")
    public String listBooks(Model model) {
        BookListResponseDTO response = bookService.findAll();
        model.addAttribute("books", response.getBooks());

        return  "/books/bookList";
    }

    @GetMapping("/books/{book_id}")
    public String viewBook(@PathVariable("book_id") Long book_id, Model model) {
        model.addAttribute("book", bookService.findById(book_id));

        return "/books/bookDetailForm";
    }
}
