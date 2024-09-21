package com.server.domain.models.view;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserViewModel implements Serializable {

    @NotBlank(message = "ID is required")
    private String id;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;

    private boolean isAccountNonExpired;

    private boolean isAccountNonLocked;

    private boolean isCredentialsNonExpired;

    private boolean isEnabled;

    @Size(min = 8, message = "Password should be at least 8 characters")
    private String password;

    @NotBlank(message = "Username is required")
    private String username;
    private String firstName;
    private String lastName;

    private Set<UserRole> authorities;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class UserRole implements Serializable {
        private String authority;
    }
}
