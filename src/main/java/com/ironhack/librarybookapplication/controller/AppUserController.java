package com.ironhack.librarybookapplication.controller;

import com.ironhack.librarybookapplication.model.AppUser;
import com.ironhack.librarybookapplication.service.AppUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class AppUserController {
    private final AppUserService appUserService;
    @GetMapping("/{userId}")
    public AppUser findById(@PathVariable Integer userId) {
        return appUserService.findById(userId);
    }
   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
    public AppUser createAppUser(@RequestBody AppUser appUser) {
        return appUserService.createAppUser(appUser);
   }

   @PutMapping("/{userId}")
    public AppUser updateAppUser(@PathVariable Integer userId, @RequestBody @Valid AppUser updatedAppUser) {
        updatedAppUser.setUserId(userId);
        return appUserService.updateAppUser(updatedAppUser);
   }

   @DeleteMapping("{userId}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAppUser(@PathVariable Integer userId) {
        appUserService.deleteAppUser(userId);
   }
}
