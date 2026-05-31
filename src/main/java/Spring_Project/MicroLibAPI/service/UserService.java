package Spring_Project.MicroLibAPI.service;

import Spring_Project.MicroLibAPI.domain.Users;
import Spring_Project.MicroLibAPI.dto.users.UserCreateRequestDTO;
import Spring_Project.MicroLibAPI.dto.users.UserPatchRequestDTO;
import Spring_Project.MicroLibAPI.dto.users.UserResponseDTO;
import Spring_Project.MicroLibAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserService {

    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long signUp(UserCreateRequestDTO request) {
        Users user = request.toEntity();
        userRepository.save(user);

        return user.getUser_id();
    }

    public UserResponseDTO findById(Long user_id) {
        Users user = userRepository.findById(user_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 없습니다. user_id: " + user_id));

        return new UserResponseDTO(user);
    }

    public UserResponseDTO patchUser(Long user_id, UserPatchRequestDTO request) {
        Users user = userRepository.findById(user_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 없습니다. user_id: " + user_id));

        user.patch(request);
        userRepository.save(user);

        return new UserResponseDTO(user);
    }
}
