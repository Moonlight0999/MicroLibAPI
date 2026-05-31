package Spring_Project.MicroLibAPI.dto.books;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class BookUpdateRequestDTO {
    private String title;
    private Long user_id;
    private String description;
    private String author;
    private String publisher;
    private LocalDate published_date;

    public BookUpdateRequestDTO(String title, Long user_id, String description, String author, String publisher, LocalDate published_date) {
        this.title = title;
        this.user_id = user_id;
        this.description = description;
        this.author = author;
        this.publisher = publisher;
        this.published_date = published_date;
    }

}
