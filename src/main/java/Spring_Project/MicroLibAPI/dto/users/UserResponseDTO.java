package Spring_Project.MicroLibAPI.dto.users;

import Spring_Project.MicroLibAPI.domain.Users;
import lombok.Getter;

@Getter
public class UserResponseDTO {
    private String name;
    private String loginId;
    private String password;

    public UserResponseDTO(Users user) {
        this.name = user.getName();
        this.loginId = user.getLoginId();
        this.password = user.getPassword();
    }
}
