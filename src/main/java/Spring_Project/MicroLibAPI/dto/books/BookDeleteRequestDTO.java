package Spring_Project.MicroLibAPI.dto.books;

import lombok.Getter;

@Getter
public class BookDeleteRequestDTO {
    private Long user_id;

    public BookDeleteRequestDTO(Long user_id) {
        this.user_id = user_id;
    }
}
