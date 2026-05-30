package Spring_Project.MicroLibAPI.dto.books;

import Spring_Project.MicroLibAPI.domain.Books;
import Spring_Project.MicroLibAPI.domain.Users;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class BookCreateRequestDTO {
    private final Users user_id;
    private String title;
    private String description;
    private String author;
    private String publisher;
    private LocalDate published_date;

    public BookCreateRequestDTO(Users user_id, String title, String description, String author, String publisher, LocalDate published_date) {
        this.user_id = user_id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.publisher = publisher;
        this.published_date = published_date;
    }

    public Books toEntity() {
        Books book = new Books();
        book.setUser_id(user_id);
        book.setTitle(title);
        book.setDescription(description);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setPublished_date(published_date);
        return book;
    }
}
