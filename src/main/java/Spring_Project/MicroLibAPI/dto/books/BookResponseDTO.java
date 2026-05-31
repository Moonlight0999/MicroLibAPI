package Spring_Project.MicroLibAPI.dto.books;

import Spring_Project.MicroLibAPI.domain.Books;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class BookResponseDTO {
    private Long book_id;
    private Long user_id;
    private String title;
    private String description;
    private String author;
    private String publisher;
    private LocalDate published_date;

    public BookResponseDTO(Books book) {
        this.book_id = book.getBook_id();
        this.user_id = book.getUser().getUser_id();
        this.title = book.getTitle();
        this.description = book.getDescription();
        this.author = book.getAuthor();
        this.publisher = book.getPublisher();
        this.published_date = book.getPublished_date();
    }
}
