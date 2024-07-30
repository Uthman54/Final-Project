package com.ironhack.librarybookapplication.repository;

import com.ironhack.librarybookapplication.model.LibraryStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LibraryStaffRepository extends JpaRepository<LibraryStaff, Integer> {

}

