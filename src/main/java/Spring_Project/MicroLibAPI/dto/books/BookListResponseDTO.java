package Spring_Project.MicroLibAPI.dto.books;

import Spring_Project.MicroLibAPI.domain.Books;
import lombok.Getter;

import java.util.List;

@Getter
public class BookListResponseDTO {
    private List<Books> Books;

    public BookListResponseDTO(List<Books> Books) {
        this.Books = Books;
    }
}
