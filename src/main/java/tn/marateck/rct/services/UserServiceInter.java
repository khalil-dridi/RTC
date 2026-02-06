package tn.marateck.rct.services;

import tn.marateck.rct.models.Role;
import tn.marateck.rct.models.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserServiceInter {
    UserEntity createUser(String username, String password, Role role);
    Optional<UserEntity> findByUsername(String username);
    List<UserEntity> findAllUsers();
    void disableUser(Long id);
    UserEntity enableUser(Long id);
    UserEntity updateUserRole(Long id, Role role);
}
