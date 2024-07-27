package com.ironhack.librarybookapplication.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name="appusers")
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column
    private String name;
    @Column
    private String userName;
    @Column
    private String password;
    @Column
    private String email;
    @OneToMany(mappedBy = "borrower")
    private List<Book> books;

    public AppUser(String name, String userName, String password, String email) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }
}
