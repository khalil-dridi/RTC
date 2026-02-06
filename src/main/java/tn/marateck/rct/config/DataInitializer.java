package tn.marateck.rct.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import tn.marateck.rct.models.Role;
import tn.marateck.rct.models.UserEntity;
import tn.marateck.rct.repositories.UserRepo;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        String adminUsername = "admin";
        if (!userRepo.existsByUsername(adminUsername)) {
            UserEntity admin = new UserEntity();
            admin.setUsername(adminUsername);
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(Role.SUPER_ADMIN);
            admin.setEnabled(true);

            userRepo.save(admin);

            System.out.println("Default SUPER_ADMIN user created with username='admin'");
        }
    }
}

