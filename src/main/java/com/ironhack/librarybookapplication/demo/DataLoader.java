package com.ironhack.librarybookapplication.demo;

import com.ironhack.librarybookapplication.model.Role;
import com.ironhack.librarybookapplication.model.User;
import com.ironhack.librarybookapplication.service.RoleService;
import com.ironhack.librarybookapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserService userService;
    private final RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        roleService.save(new Role("ROLE_USER"));
        roleService.save(new Role("ROLE_ADMIN"));

        userService.saveUser(new User("Christiano Ronaldo", "ronaldo", "ronaldo1"));
        userService.saveUser(new User("Pep Guardiola", "pep", "pep123"));
        userService.saveUser(new User("Andreas Iniesta", "andreas", "iniesta4"));
        userService.saveUser(new User("Hansi Flick", "flick", "hansi20"));

        roleService.addRoleToUser("ronaldo", "ROLE_USER");
        roleService.addRoleToUser("pep", "ROLE_ADMIN");
        roleService.addRoleToUser("andreas", "ROLE_USER");
        roleService.addRoleToUser("flick", "ROLE_ADMIN");
        roleService.addRoleToUser("flick", "ROLE_USER");
    }
}
