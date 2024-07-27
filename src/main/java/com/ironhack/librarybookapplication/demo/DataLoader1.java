package com.ironhack.librarybookapplication.demo;

import com.ironhack.librarybookapplication.model.Book;
import com.ironhack.librarybookapplication.model.GeneralUser;
import com.ironhack.librarybookapplication.model.LibraryStaff;
import com.ironhack.librarybookapplication.repository.BookRepository;
import com.ironhack.librarybookapplication.repository.GeneralUserRepository;
import com.ironhack.librarybookapplication.repository.LibraryStaffRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j

public class DataLoader1 implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final LibraryStaffRepository libraryStaffRepository;
    private final GeneralUserRepository generalUserRepository;
    @Override
    public void run(String... args) throws Exception {
        log.info("Loading data...");


        Book book1 = new Book("Don Quixote","Miguel de Cervantes",2018);
        Book book2 = new Book("The Adventures of Huckleberry Finn","Mark Twain",2001);
        Book book3 =new Book("Treasure Island","Robert Louis Stevenson",1981);
        Book book4 = new Book("Pride and Prejudice","Jane Austen",1995);
        Book book5 =new Book("Wuthering Heights","Emily Brontë",1995);

        var listOfBooks = List.of(book1,book2,book3,book4,book5);
        bookRepository.saveAll(listOfBooks);

        GeneralUser generalUser1 = new GeneralUser("Lionel Messi","Messi","lionel1","messi1@gmail.com");
        GeneralUser generalUser2 = new GeneralUser("Christiano Ronaldo","ronaldo","ronald1","ronaldo1@yahoo.com");
        GeneralUser generalUser3 = new GeneralUser("Andreas Iniesta","andreas","iniesta4","andreas4@gmail.com");
        GeneralUser generalUser4 = new GeneralUser("Xavi Hernandez","xavi","xavi123","xavi80@gmail.com");
        GeneralUser generalUser5 = new GeneralUser("Samuel Eto","eto","eto20","eto90@yahoo.com");

        var listOfGeneralUsers = List.of(generalUser1,generalUser2,generalUser3,generalUser4,generalUser5);
        generalUserRepository.saveAll(listOfGeneralUsers);

        LibraryStaff libraryStaff1 = new LibraryStaff("Hansi Flick","flick","hansi20","hansi50@gmail.com");
        LibraryStaff libraryStaff2 = new LibraryStaff("Pep Guardiola","pep","pep123","pep60@gmail.com");

        var listOfLibraryStaff = List.of(libraryStaff1,libraryStaff2);
        libraryStaffRepository.saveAll(listOfLibraryStaff);

    }
}
