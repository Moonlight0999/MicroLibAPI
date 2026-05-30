package Spring_Project.MicroLibAPI.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;
    @Getter @Setter
    private String title;
    @Getter @Setter
    private String author;
    @Getter @Setter
    private String publisher;
    @Getter @Setter
    private Date publishedDate;
    @Getter @Setter
    private String text;

}
