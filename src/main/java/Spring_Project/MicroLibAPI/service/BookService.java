package Spring_Project.MicroLibAPI.service;

import Spring_Project.MicroLibAPI.domain.Books;
import Spring_Project.MicroLibAPI.dto.books.BookCreateRequestDTO;
import Spring_Project.MicroLibAPI.repository.BookRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Books> findAll() {
        return bookRepository.findAll();

    }

    public void createBook(BookCreateRequestDTO request) {
        Books book = request.toEntity();
        bookRepository.save(book);
    }
}
