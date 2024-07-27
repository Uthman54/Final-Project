package com.ironhack.librarybookapplication.controller;

import com.ironhack.librarybookapplication.model.LibraryStaff;
import com.ironhack.librarybookapplication.service.LibraryStaffService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("library_staff")
public class LibraryStaffController {
    private final LibraryStaffService libraryStaffService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LibraryStaff addLibraryStaff(@RequestBody @Valid LibraryStaff libraryStaff) {
        return libraryStaffService.addLibraryStaff(libraryStaff);
    }
    @GetMapping
    public List<LibraryStaff> getAllLibraryStaff() {
        return libraryStaffService.getAllLibraryStaff();
    }

    @GetMapping("/userId")
    public LibraryStaff getLibraryStaffById(@PathVariable Integer UserId) {
        return libraryStaffService.getLibraryStaffById(UserId);
    }

    @PatchMapping("/{userId}/password")
    public LibraryStaff updateLibraryStaff(@PathVariable Integer userId, @RequestParam @Valid String password) {
        return libraryStaffService.updateLibraryStaffPassword(userId,password);

    }



}
