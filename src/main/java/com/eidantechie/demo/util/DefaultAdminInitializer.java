package com.eidantechie.demo.util;

import com.eidantechie.demo.entity.User;
import com.eidantechie.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class DefaultAdminInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Check if admin user already exists
        User admin = userRepository.findByRole("ADMIN");
        if (admin == null) {
            // Create and save the default admin user
            User adminUser = new User();
            adminUser.setUsername("admin");
            adminUser.setPassword(passwordEncoder.encode("admin123")); // Set a default password

            adminUser.setRole("ADMIN");
            // Debugging info before saving
            System.out.println("Creating user: " + adminUser.getUsername() + " with role: " + adminUser.getRole());

            // Save the user
            userRepository.save(adminUser);
            System.out.println("Default admin user created");
        } else {
            System.out.println("Admin user already exists.");
        }
    }

}
