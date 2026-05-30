package Spring_Project.MicroLibAPI.dto.users;

import Spring_Project.MicroLibAPI.domain.Users;
import lombok.Getter;

import java.util.Optional;

@Getter
public class UserResponseDTO {
    private Long user_id;
    private String name;
    private String login_id;
    private String password;

    public UserResponseDTO(Users user) {
        this.user_id = user.getUser_id();
        this.name = user.getName();
        this.login_id = user.getLogin_id();
        this.password = user.getPassword();
    }
}
