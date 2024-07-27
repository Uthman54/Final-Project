package com.ironhack.librarybookapplication.service;

import com.ironhack.librarybookapplication.model.LibraryStaff;
import com.ironhack.librarybookapplication.repository.LibraryStaffRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LibraryStaffService {
    private final LibraryStaffRepository libraryStaffRepository;

    //Add Library Staff
    public LibraryStaff addLibraryStaff(LibraryStaff libraryStaff) {
        log.info("Add library staff: {}", libraryStaff);
        return libraryStaffRepository.save(libraryStaff);
    }

    public LibraryStaff getLibraryStaffById(int userId) {

        log.info("Get library staff by id: {}", userId);
        return libraryStaffRepository.findById(userId).orElse(null);
    }

    public List<LibraryStaff> getAllLibraryStaff() {
        return libraryStaffRepository.findAll();
    }

    public LibraryStaff updateLibraryStaffPassword(Integer userId, String password) {
        LibraryStaff libraryStaff = libraryStaffRepository.findById(userId).orElseThrow(() -> new RuntimeException("LibraryStaff not found"));
        libraryStaff.setPassword(password);
        return libraryStaffRepository.save(libraryStaff);
    }
}
