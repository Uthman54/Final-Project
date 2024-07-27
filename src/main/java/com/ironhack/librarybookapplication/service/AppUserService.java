package com.ironhack.librarybookapplication.service;

import com.ironhack.librarybookapplication.model.AppUser;
import com.ironhack.librarybookapplication.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppUserService {
    private final AppUserRepository appUserRepository;
    //Add AppUser
    public AppUser createAppUser(AppUser appUser) {
        log.info("Saving appUser: {}", appUser);
        return appUserRepository.save(appUser);
    }

    public AppUser findById(int userId) {
        log.info("Finding app user by id: {}", userId);
        return appUserRepository.findById(userId).orElseThrow(() -> new RuntimeException("AppUser not found"));
    }

     //Updating AppUser Information "Put"
    public AppUser updateAppUser(AppUser updatedAppUser) {
        log.info("Updating appUser: {}", updatedAppUser);
        AppUser appUser = appUserRepository.findById(updatedAppUser.getUserId()).orElseThrow(() -> new RuntimeException("AppUser not found"));
        appUser.setName(updatedAppUser.getName());
        appUser.setUserName(updatedAppUser.getUserName());
        appUser.setPassword(updatedAppUser.getPassword());
        appUser.setEmail(updatedAppUser.getEmail());

        return appUserRepository.save(updatedAppUser);

    }

    public void deleteAppUser(int userId) {
        log.info("Deleting user: {}", userId);
        appUserRepository.deleteById(userId);
    }


}
