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
}
