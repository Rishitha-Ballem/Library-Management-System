package com.epam.controller;

import com.epam.dto.Book;
import com.epam.dto.User;
import com.epam.service.LibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    // BOOK ENDPOINTS

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return libraryService.getAllBooks();
    }

    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable Long bookId) {
        return libraryService.getBookById(bookId);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return libraryService.addBook(book);
    }

    @PutMapping("/books/{bookId}")
    public Book updateBook(@PathVariable Long bookId, @RequestBody Book book) {
        return libraryService.updateBook(bookId, book);
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        libraryService.deleteBook(bookId);
    }

    // USER ENDPOINTS

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return libraryService.getAllUsers();
    }

    @GetMapping("/users/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return libraryService.getUserByUsername(username);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return libraryService.addUser(user);
    }

    @PutMapping("/users/{username}")
    public User updateUser(@PathVariable String username, @RequestBody User user) {
        return libraryService.updateUser(username, user);
    }

    @DeleteMapping("/users/{username}")
    public void deleteUser(@PathVariable String username) {
        libraryService.deleteUser(username);
    }

    // BOOK ISSUE & RELEASE FOR USER

    @PostMapping("/users/{username}/books/{bookId}")
    public String issueBook(@PathVariable String username, @PathVariable Long bookId) {
        return libraryService.issueBook(username, bookId);
    }

    @DeleteMapping("/users/{username}/books/{bookId}")
    public String releaseBook(@PathVariable String username, @PathVariable Long bookId) {
        return libraryService.releaseBook(username, bookId);
    }
}
