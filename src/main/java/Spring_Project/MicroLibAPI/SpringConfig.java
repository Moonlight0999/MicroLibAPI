package Spring_Project.MicroLibAPI;

import Spring_Project.MicroLibAPI.repository.BookRepository;
import Spring_Project.MicroLibAPI.repository.UserRepository;
import Spring_Project.MicroLibAPI.service.BookService;
import Spring_Project.MicroLibAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Autowired
    public SpringConfig(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @Bean
    public UserService userService() {
        return new UserService(userRepository);
    }
    @Bean
    public BookService bookService() {
        return new BookService(bookRepository);
    }
}
