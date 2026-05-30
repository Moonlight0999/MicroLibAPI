package Spring_Project.MicroLibAPI.repository;

import Spring_Project.MicroLibAPI.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaUserRepository extends JpaRepository<Users, Long>, UserRepository {

}
