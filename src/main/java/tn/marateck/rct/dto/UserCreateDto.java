package tn.marateck.rct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.marateck.rct.models.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto {
    private String username;
    private String password;
    private Role role;
}

