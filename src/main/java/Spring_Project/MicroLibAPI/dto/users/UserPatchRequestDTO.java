package Spring_Project.MicroLibAPI.dto.users;

import lombok.Getter;

@Getter
public class UserPatchRequestDTO {
    private String name;
    private String loginId;
    private String password;

    public UserPatchRequestDTO(String name, String loginId, String password) {
        this.name = name;
        this.loginId = loginId;
        this.password = password;
    }
}
