package Spring_Project.MicroLibAPI.repository;

import Spring_Project.MicroLibAPI.domain.Users;
import Spring_Project.MicroLibAPI.dto.users.UserPatchRequestDTO;

import java.util.Map;
import java.util.Optional;

public interface UserRepository {
    Users save(Users users);

    Optional<Users> findById(Long userId);
}
