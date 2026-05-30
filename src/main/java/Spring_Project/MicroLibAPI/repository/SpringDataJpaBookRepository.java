package Spring_Project.MicroLibAPI.repository;

import Spring_Project.MicroLibAPI.domain.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaBookRepository extends JpaRepository<Books, Long>, BookRepository {
}
