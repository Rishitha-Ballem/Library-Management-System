package com.epam.service;

import com.epam.dto.Book;
import com.epam.dto.User;
import com.epam.feign.BookClient;
import com.epam.feign.UserClient;
import com.epam.model.Library;
import com.epam.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    private final LibraryRepository repository;
    private final BookClient bookClient;
    private final UserClient userClient;

    public LibraryService(LibraryRepository repository, BookClient bookClient, UserClient userClient) {
        this.repository = repository;
        this.bookClient = bookClient;
        this.userClient = userClient;
    }

    public List<Book> getAllBooks() {
        return bookClient.getAllBooks();
    }

    public Book getBookById(Long bookId) {
        return bookClient.getBookById(bookId);
    }

    public Book addBook(Book book) {
        return bookClient.saveBook(book);
    }

    public Book updateBook(Long bookId, Book book) {
        return bookClient.updateBook(bookId, book);
    }

    public void deleteBook(Long bookId) {
        repository.deleteAll(repository.findAll().stream()
                .filter(lib -> lib.getBookId().equals(bookId))
                .toList());
        bookClient.deleteBook(bookId);
    }

    public List<User> getAllUsers() {
        return userClient.getAllUsers();
    }

    public User getUserByUsername(String username) {
        return userClient.getUserByUsername(username);
    }

    public User addUser(User user) {
        return userClient.saveUser(user);
    }

    public User updateUser(String username, User user) {
        return userClient.updateUser(username, user);
    }

    public void deleteUser(String username) {
        repository.deleteAll(repository.findByUsername(username));
        userClient.deleteUser(username);
    }

    public String issueBook(String username, Long bookId) {
        List<Library> borrowed = repository.findByUsername(username);
        if (borrowed.size() >= 3) {
            return "Cannot issue more than 3 books.";
        }
        Library entry = new Library(System.currentTimeMillis(), username, bookId);
        repository.save(entry);
        return "Book issued successfully!";
    }

    public String releaseBook(String username, Long bookId) {
        repository.findByUsername(username)
                .stream()
                .filter( lib-> lib.getBookId().equals(bookId))
                .findFirst()
                .ifPresent(repository::delete);
        return "Book released successfully!";
    }
}
