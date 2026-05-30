package Spring_Project.MicroLibAPI.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Users {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @Column(name= "user_id")
    private Long user_id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String login_id;
    @Getter @Setter
    private String password;

    public void patchProfile(String name, String login_id, String password) {
        if (name != null) this.name = name;
        if (login_id != null) this.login_id = login_id;
        if (password != null) this.password = password;
    }
}
