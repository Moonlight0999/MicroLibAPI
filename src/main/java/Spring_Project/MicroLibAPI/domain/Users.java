package Spring_Project.MicroLibAPI.domain;

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
    private String login_id;
    private String password;

    public void patchProfile(String name, String login_id, String password) {
        if (name != null && !name.isBlank()) this.name = name;
        if (login_id != null && !login_id.isBlank()) this.login_id = login_id;
        if (password != null && !password.isBlank()) this.password = password;
    }
}
