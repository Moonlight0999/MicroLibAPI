package Spring_Project.MicroLibAPI.service;

import Spring_Project.MicroLibAPI.domain.Users;
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

    public Long signUp(Users user) {
        userRepository.save(user);
        return user.getUser_id();
    }
}
