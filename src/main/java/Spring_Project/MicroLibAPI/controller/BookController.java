package Spring_Project.MicroLibAPI.controller;

import Spring_Project.MicroLibAPI.dto.books.BookCreateRequestDTO;
import Spring_Project.MicroLibAPI.dto.books.BookListRequestDTO;
import Spring_Project.MicroLibAPI.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
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
        model.addAttribute("books", bookService.findAll());

        return  "/books/bookList";
    }
}
