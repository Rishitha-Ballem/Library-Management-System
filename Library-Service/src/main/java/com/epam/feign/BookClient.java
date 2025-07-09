package com.epam.feign;

import com.epam.dto.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "book-service")
public interface BookClient {

    @GetMapping("/books")
    List<Book> getAllBooks();

    @GetMapping("/books/{bookId}")
    Book getBookById(@PathVariable Long bookId);

    @PostMapping("/books")
    Book saveBook(@RequestBody Book book);

    @PutMapping("/books/{bookId}")
    Book updateBook(@PathVariable Long bookId, @RequestBody Book book);

    @DeleteMapping("/books/{bookId}")
    void deleteBook(@PathVariable Long bookId);
}
