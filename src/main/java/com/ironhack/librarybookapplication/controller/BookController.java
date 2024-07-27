package com.ironhack.librarybookapplication.controller;

import com.ironhack.librarybookapplication.model.Book;
import com.ironhack.librarybookapplication.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public Optional <Book> getBookById(@PathVariable int bookId) {
        return bookService.getBookById(bookId);
    }

    @GetMapping("/by-author-name")
    public List<Book> getBooksByAuthorName(@RequestParam String authorName) {
        return bookService.getByAuthorName(authorName);
    }

    @GetMapping("/by-book-title")
    public List<Book> getBooksByBookTitle(@RequestParam String bookTitle) {
        return bookService.getByBookTitle(bookTitle);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PostMapping("/{bookId}/user/{userId}/borrow")
    public String borrowBook(@PathVariable int bookId, @PathVariable int userId) {
        return bookService.borrowBook(bookId, userId);
    }

    @PostMapping("/{bookId}/user/{userId}/return")
    public String returnBook(@PathVariable int bookId, @PathVariable int userId) {
        return bookService.returnBook(bookId, userId);
    }

    @GetMapping("/{bookId}/availability")
    public String checkBookAvailability(@PathVariable int bookId) {
        return bookService.checkBookAvailability(bookId);

    }

    @DeleteMapping("/{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int bookId) {
        bookService.deleteBook(bookId);
    }




}
