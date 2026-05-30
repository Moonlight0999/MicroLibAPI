package Spring_Project.MicroLibAPI.repository;

import Spring_Project.MicroLibAPI.domain.Book;

import java.util.Optional;

public interface BookRepository {
    Book save(Book book);
    Optional<Book> findById(Long id);
}
