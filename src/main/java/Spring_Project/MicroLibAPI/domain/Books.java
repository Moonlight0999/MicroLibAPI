package Spring_Project.MicroLibAPI.domain;

import Spring_Project.MicroLibAPI.dto.books.BookUpdateRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
public class Books {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;
    private String title;
    private String description;
    private String author;
    private String publisher;
    private LocalDate published_date;

    public void update(BookUpdateRequestDTO request) {
        this.title = request.getTitle();
        this.description = request.getDescription();
        this.author = request.getAuthor();
        this.publisher = request.getPublisher();
        this.published_date = request.getPublished_date();
    }
}
