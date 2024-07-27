package com.ironhack.librarybookapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table
public class LibraryStaff extends AppUser {
    public LibraryStaff(String name, String userName, String password, String email) {
        super(name, userName, password, email);
    }
}
