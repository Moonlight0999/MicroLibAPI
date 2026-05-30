package Spring_Project.MicroLibAPI.repository;

import Spring_Project.MicroLibAPI.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataBookRepository extends BookRepository, JpaRepository<Book, Long> {

}
