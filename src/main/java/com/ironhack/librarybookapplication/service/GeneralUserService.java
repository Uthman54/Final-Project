package com.ironhack.librarybookapplication.service;

import com.ironhack.librarybookapplication.model.GeneralUser;
import com.ironhack.librarybookapplication.repository.GeneralUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class GeneralUserService {
    private final GeneralUserRepository generalUserRepository;

    public List<GeneralUser> getAllGeneralUsers() {
        return generalUserRepository.findAll();
    }

    //Add General AppUser
    public GeneralUser addGeneralUser(GeneralUser generalUser) {
        log.info("Adding a new GeneralAppUser:{}", generalUser);
        return generalUserRepository.save(generalUser);
    }

    //Find by ID
    public Optional<GeneralUser> getGeneralUserById(Integer userId) {
        log.info("Getting General user by id:{}", userId);
        var generalUserRetrieved = generalUserRepository.findById(userId);
        if (generalUserRetrieved.isEmpty()) {
            log.warn("General user with id {} not found", userId);
        }
        return generalUserRetrieved;
    }

    //find By userName
    public Optional<GeneralUser> getByUserName(String username) {
        log.info("Getting by Username: {}", username);
        return generalUserRepository.findByUserName(username);
    }

    //find By email
    public List<GeneralUser> getByEmail(String email) {
        log.info("Getting general user by email:{} ", email);
        return generalUserRepository.findByEmail(email);
    }

    //Updating General AppUser Information "Patch"

    public GeneralUser updateGeneralUserEmail(Integer userId, String email) {
        GeneralUser generalUser = generalUserRepository.findById(userId).orElseThrow(() -> new RuntimeException("GeneralAppUser not found"));
        generalUser.setEmail(email);
        return generalUserRepository.save(generalUser);
    }

}
