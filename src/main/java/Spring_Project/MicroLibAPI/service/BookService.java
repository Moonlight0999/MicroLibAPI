package Spring_Project.MicroLibAPI.service;

import Spring_Project.MicroLibAPI.repository.BookRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
