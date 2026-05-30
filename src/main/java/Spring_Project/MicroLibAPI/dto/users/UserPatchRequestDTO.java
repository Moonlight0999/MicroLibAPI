package Spring_Project.MicroLibAPI.dto.users;

import lombok.Getter;

@Getter
public class UserPatchRequestDTO {
    private Long user_id;
    private String name;
    private String login_id;
    private String password;

    public UserPatchRequestDTO(Long user_id, String name, String login_id, String password) {
        this.user_id = user_id;
        this.name = name;
        this.login_id = login_id;
        this.password = password;
    }
}
