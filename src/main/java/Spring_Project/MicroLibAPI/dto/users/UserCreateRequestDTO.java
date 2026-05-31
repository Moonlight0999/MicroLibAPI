package Spring_Project.MicroLibAPI.dto.users;

import Spring_Project.MicroLibAPI.domain.Users;
import lombok.Getter;

@Getter
public class UserCreateRequestDTO {
    private String name;
    private String loginId;
    private String password;

    public UserCreateRequestDTO(String name, String loginId, String password) {
        this.name = name;
        this.loginId = loginId;
        this.password = password;
    }

    public Users toEntity() {
        Users users = new Users();
        users.setName(name);
        users.setLoginId(loginId);
        users.setPassword(password);
        return users;
    }
}
