package com.ironhack.librarybookapplication.controller;

import com.ironhack.librarybookapplication.model.GeneralUser;
import com.ironhack.librarybookapplication.service.GeneralUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class GeneralUserController {
    private final GeneralUserService generalUserService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GeneralUser addGeneralUser(@RequestBody GeneralUser generalUser) {
        return generalUserService.addGeneralUser(generalUser);
    }
    @GetMapping
    public List<GeneralUser> getAllGeneralUsers() {
        return generalUserService.getAllGeneralUsers();
    }
    @GetMapping("/{userId}")
    public Optional<GeneralUser> getGeneralUserById(@PathVariable Integer userId) {
        return generalUserService.getGeneralUserById(userId);
    }
    @GetMapping("/get-by-username")
    public Optional<GeneralUser> getByUsername(@RequestParam String username) {
        return generalUserService.getByUserName(username);
    }
    @GetMapping("/get-by-email")
    public List<GeneralUser> getByEmail(@RequestParam String email) {
        return generalUserService.getByEmail(email);
    }

    @PatchMapping("/{userId}/email")
    public GeneralUser updateGeneralUserEmail(@PathVariable Integer userId, @RequestParam @Valid String email) {
        return generalUserService.updateGeneralUserEmail(userId, email);
    }
}
