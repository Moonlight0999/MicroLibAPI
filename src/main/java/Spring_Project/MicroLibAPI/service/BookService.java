package Spring_Project.MicroLibAPI.service;

import Spring_Project.MicroLibAPI.domain.Books;
import Spring_Project.MicroLibAPI.domain.Users;
import Spring_Project.MicroLibAPI.dto.books.BookCreateRequestDTO;
import Spring_Project.MicroLibAPI.dto.books.BookListResponseDTO;
import Spring_Project.MicroLibAPI.dto.books.BookUpdateRequestDTO;
import Spring_Project.MicroLibAPI.dto.books.BookResponseDTO;
import Spring_Project.MicroLibAPI.repository.BookRepository;
import Spring_Project.MicroLibAPI.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public class BookService {
    private BookRepository bookRepository;
    private UserRepository userRepository;

    public BookService(BookRepository bookRepository,  UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public BookResponseDTO findById(Long book_id) {
        Optional<Books> book = Optional.of(bookRepository.findById(book_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 책이 존재하지 없습니다. book_id: " + book_id)));

        return new BookResponseDTO(book.get());
    }

    public BookListResponseDTO findAll() {
        return new BookListResponseDTO(bookRepository.findAll());
    }

    public void createBook(BookCreateRequestDTO request) {
        Optional<Users> user = Optional.of(userRepository.findById(request.getUser_id())
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 없습니다. book_id: " + request.getUser_id())));

        Books book = request.toEntity(user.get());
        bookRepository.save(book);
    }

    public void updateBook(Long book_id, BookUpdateRequestDTO request) {
        Optional<Books> book = Optional.of(bookRepository.findById(book_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 책이 존재하지 없습니다. book_id: " + book_id)));

        book.get().update(request);
    }

    public void deleteById(Long book_id) {
        Optional<Books> book = Optional.of(bookRepository.findById(book_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 책이 존재하지 없습니다. book_id: " + book_id)));
        bookRepository.deleteById(book_id);
    }
}
