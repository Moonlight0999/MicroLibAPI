package Spring_Project.MicroLibAPI.repository;

import Spring_Project.MicroLibAPI.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByLoginId(String login_id);
}
