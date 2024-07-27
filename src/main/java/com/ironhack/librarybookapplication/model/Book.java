package com.ironhack.librarybookapplication.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="books")
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    @Column
    private String title;
    @Column
    private String author;
    @Column
    private int publishedYear;
    @Column
    private boolean isBorrowed;
    @ManyToOne(fetch = FetchType.EAGER)
    private AppUser borrower;

    //Constructor for Setting basic fields
    public Book(String title, String author, int publishedYear) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    //Constructor for borrowing a book

    public Book(String title, String author, int publishedYear, AppUser borrower) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.isBorrowed = true;
        this.borrower = borrower;
    }

    //method to borrow a book

    public void borrowBook(AppUser borrower) {
        if (!this.isBorrowed) {
            this.isBorrowed = true;
            this.borrower = borrower;
        } else {
            throw new IllegalStateException("Book is already borrowed.");
        }
    }

    //method to return book

    public void returnBook() {
        if (this.isBorrowed) {
            this.isBorrowed = false;
            this.borrower = null;
        } else {
            throw new IllegalStateException("Book is not currently borrowed.");
        }
    }


}
