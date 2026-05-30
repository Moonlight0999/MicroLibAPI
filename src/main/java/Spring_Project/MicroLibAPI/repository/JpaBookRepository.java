package Spring_Project.MicroLibAPI.repository;

import Spring_Project.MicroLibAPI.domain.Book;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class JpaBookRepository implements BookRepository {

    private final EntityManager em;
    public JpaBookRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.empty();
    }
}
