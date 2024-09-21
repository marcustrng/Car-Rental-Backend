package com.server.services;

import com.server.domain.models.binding.UserRegisterBindingModel;
import com.server.domain.models.view.UserViewModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    boolean register(UserRegisterBindingModel model);

    UserViewModel getUserByUsername(String username);
}
