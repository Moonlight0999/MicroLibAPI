package Spring_Project.MicroLibAPI.domain;

import Spring_Project.MicroLibAPI.dto.users.UserPatchRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Users {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "user_id")
    private Long user_id;
    private String name;
    private String loginId;
    private String password;

    public void patch(UserPatchRequestDTO request) {
        String name = request.getName();
        String loginId = request.getLoginId();
        String password = request.getPassword();
        if (name != null && !name.isBlank()) this.name = name;
        if (loginId != null && !loginId.isBlank()) this.loginId = loginId;
        if (password != null && !password.isBlank()) this.password = password;
    }
}
