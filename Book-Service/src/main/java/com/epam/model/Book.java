package com.epam.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



@Entity

public class Book {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Book name cannot be blank")
    @Size(max = 100, message = "Book name must be less than 100 characters")
    private String name;
    @NotBlank(message = "Publisher name cannot be blank")
    @Size(max = 100, message = "Publisher name must be less than 100 characters")
    private String publisher;
    @NotBlank(message = "Author name cannot be blank")
    @Size(max = 100, message = "Author name must be less than 100 characters")
    private String author;

    public Book(String publisher, String name, Long id, String author) {
        this.publisher = publisher;
        this.name = name;
        this.id = id;
        this.author = author;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
