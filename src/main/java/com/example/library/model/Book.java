package com.example.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String title;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String author;
    public String publisher;
    public int publication_Year;
    public int quantity;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public String getPublisher(){ return publisher;}

    public void setPublisher(String publisher){this.publisher = publisher;}

    public int getPublication_Year() {
        return publication_Year;
    }

    public void setPublication_Year(int publication_Year) {
        this.publication_Year = publication_Year;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quanity) {
        this.quantity = quanity;
    }
}
