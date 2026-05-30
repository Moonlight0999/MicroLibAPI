package Spring_Project.MicroLibAPI.dto.users;

import lombok.Getter;

@Getter
public class UserCreateRequestDTO {
    private String name;
    private String login_id;
    private String password;

    public UserCreateRequestDTO(String name, String login_id, String password) {
        this.name = name;
        this.login_id = login_id;
        this.password = password;
    }

}
