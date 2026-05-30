package Spring_Project.MicroLibAPI.repository;

import Spring_Project.MicroLibAPI.domain.Books;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Books save(Books book);

    Optional<Books> findById(Long id);

    List<Books> findAll();
}
