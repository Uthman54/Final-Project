package com.ironhack.librarybookapplication.repository;

import com.ironhack.librarybookapplication.model.LibraryStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibraryStaffRepository extends JpaRepository<LibraryStaff, Integer> {

}

