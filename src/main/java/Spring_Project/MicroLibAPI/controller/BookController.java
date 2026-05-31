package Spring_Project.MicroLibAPI.controller;

import Spring_Project.MicroLibAPI.dto.books.*;
import Spring_Project.MicroLibAPI.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books/new")
    public ResponseEntity<Long> createBook(@RequestBody BookCreateRequestDTO request) {
        Long book_id = bookService.createBook(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(book_id);
    }

    @GetMapping("/books")
    public ResponseEntity<BookListResponseDTO> listBooks() {
        BookListResponseDTO response = bookService.findAll();

        return  ResponseEntity.ok(response);
    }

    @GetMapping("/books/{book_id}")
    public ResponseEntity<BookResponseDTO> viewBook(@PathVariable("book_id") Long book_id) {
         BookResponseDTO response = bookService.findById(book_id);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/books/{book_id}")
    public ResponseEntity<BookResponseDTO> updateBook(@PathVariable("book_id") Long book_id, @RequestBody BookUpdateRequestDTO request) {
        BookResponseDTO book = bookService.findById(book_id);

        if (!book.getUser_id().equals(request.getUser_id())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        bookService.updateBook(book_id, request);
        BookResponseDTO updatedBook = bookService.findById(book_id);

        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/books/{book_id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("book_id") Long book_id, @RequestBody BookDeleteRequestDTO request) {
        BookResponseDTO book = bookService.findById(book_id);

        if (!book.getUser_id().equals(request.getUser_id())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        bookService.deleteById(book_id);
        return ResponseEntity.noContent().build();
    }
}
