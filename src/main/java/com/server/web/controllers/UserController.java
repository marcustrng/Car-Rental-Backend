package com.server.web.controllers;


import com.server.domain.models.binding.UserRegisterBindingModel;
import com.server.domain.models.view.UserViewModel;
import com.server.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register", consumes = "application/json")
    ResponseEntity<Boolean> register(@RequestBody @Valid UserRegisterBindingModel model) throws URISyntaxException {
        boolean result = this.userService.register(model);

        return ResponseEntity.created(new URI("/users/register")).body(result);
    }

    @GetMapping(value = "/{username}")
    ResponseEntity<UserViewModel> getUserByUsername(@PathVariable String username) {
        UserViewModel result = this.userService.getUserByUsername(username);

        return ResponseEntity.ok().body(result);
    }
}
