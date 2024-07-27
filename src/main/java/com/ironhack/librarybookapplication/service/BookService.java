package com.ironhack.librarybookapplication.service;

import com.ironhack.librarybookapplication.model.AppUser;
import com.ironhack.librarybookapplication.model.Book;
import com.ironhack.librarybookapplication.repository.BookRepository;
import com.ironhack.librarybookapplication.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AppUserRepository appUserRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    //add a book
    public Book addBook(Book book){
        log.info("Adding a new book:{}",book);
        return bookRepository.save(book);
    }

    // find by ID
    public Optional<Book>getBookById(Integer bookId){
        log.info("Getting book by id:{}",bookId);
        var bookRetrieved = bookRepository.findById(bookId);
        if (bookRetrieved.isEmpty()){
            log.warn("Book with id {} not found",bookId);
        }
        return bookRetrieved;
    }

    //find By Author's Name
    public List<Book>getByAuthorName(String author){
        log.info("Getting by author's name: {}", author);
        return bookRepository.findByAuthor(author);
    }

    //find By Book Title
    public List<Book> getByBookTitle(String title){
        log.info("Getting by Book title: {}",title);
        return bookRepository.findByTitle(title);
    }

    public String borrowBook(int bookId, int userId) {
        Optional<Book> bookOpt = bookRepository.findById(bookId);
        Optional<AppUser> userOpt = appUserRepository.findById(userId);

        if (bookOpt.isPresent() && userOpt.isPresent()) {
            Book book = bookOpt.get();
            AppUser appUser = userOpt.get();

            try {
                book.borrowBook(appUser); // Using the borrowBook method from Book class
                bookRepository.save(book);
                return "Book borrowed successfully by appUser: " + appUser.getName();
            } catch (IllegalStateException e) {
                return e.getMessage();
            }
        }

        return "Book or AppUser not found.";
    }

    public String returnBook(int bookId, int userId) {
        Optional<Book> bookOpt = bookRepository.findById(bookId);
        Optional<AppUser> userOpt = appUserRepository.findById(userId);

        if (bookOpt.isPresent() && userOpt.isPresent()) {
            Book book = bookOpt.get();
            AppUser user = userOpt.get();

            if (user.equals(book.getBorrower())) { // Ensure the returning user is the borrower
                try {
                    book.returnBook(); // Using the returnBook method from Book class
                    bookRepository.save(book);
                    return "Book returned successfully by user: " + user.getName();
                } catch (IllegalStateException e) {
                    return e.getMessage();
                }
            } else {
                return "Book was not borrowed by this user.";
            }
        }

        return "Book or AppUser not found.";
    }


    public String checkBookAvailability(int bookId) {
        Optional<Book> bookOpt = bookRepository.findById(bookId);
        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            return book.isBorrowed() ? "Book is currently borrowed." : "Book is available.";
        }
        return "Book not found.";
    }

    public void deleteBook(int bookId) {
        bookRepository.deleteById(bookId);
    }


}
