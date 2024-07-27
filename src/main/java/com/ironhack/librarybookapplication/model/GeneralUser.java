package com.ironhack.librarybookapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table
public class GeneralUser extends AppUser {
    public GeneralUser(String name, String userName, String password, String email) {
        super(name, userName, password, email);
    }
}