package tn.marateck.rct.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.marateck.rct.models.Role;
import tn.marateck.rct.models.UserEntity;
import tn.marateck.rct.repositories.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServiceInter {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserEntity createUser(String username, String password, Role role) {
        if (userRepo.existsByUsername(username)) {
            throw new IllegalArgumentException("Username already exists");
        }
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);
        user.setEnabled(true);
        return userRepo.save(user);
    }

    @Override
    public Optional<UserEntity> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<UserEntity> findAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public void disableUser(Long id) {
        userRepo.findById(id).ifPresent(u -> {
            u.setEnabled(false);
            userRepo.save(u);
        });
    }
}
