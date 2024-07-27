package com.ironhack.librarybookapplication.repository;

import com.ironhack.librarybookapplication.model.GeneralUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GeneralUserRepository extends JpaRepository<GeneralUser,Integer> {
    Optional<GeneralUser> findByUserName(String username);
    List<GeneralUser>findByEmail(String email);
}
