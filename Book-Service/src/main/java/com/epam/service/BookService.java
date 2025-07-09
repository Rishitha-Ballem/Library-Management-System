package com.epam.service;

import com.epam.model.Book;
import com.epam.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Long id, Book newBookData) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setName(newBookData.getName());
                    book.setPublisher(newBookData.getPublisher());
                    book.setAuthor(newBookData.getAuthor());
                    return bookRepository.save(book);
                }).orElseThrow(() -> new RuntimeException("Book not found!"));
    }
}
