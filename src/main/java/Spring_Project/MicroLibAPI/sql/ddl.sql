CREATE TABLE users (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    login_id VARCHAR(20) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

DROP TABLE users

CREATE TABLE books (
    book_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    author VARCHAR(20) NOT NULL,
    publisher VARCHAR(255) NOT NULL,
    published_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_books_users FOREIGN KEY (user_id) REFERENCES users(user_id)
);