package com.example.edadeda_backend.controller;

import com.example.edadeda_backend.model.dto.user.UserCreateRequest;
import com.example.edadeda_backend.model.dto.user.UserResponse;
import com.example.edadeda_backend.model.dto.user.UserUpdateRequest;
import com.example.edadeda_backend.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<UserResponse> getUsers() {
        return this.userService.getAllUsers();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody UserCreateRequest user) {
        return this.userService.createUser(user);
    }

    @GetMapping(path = "/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        return this.userService.getUser(id);
    }

    @PutMapping(path = "/{id}")
    public UserResponse updateUser(@PathVariable Long id, @RequestBody UserUpdateRequest user) {
        return this.userService.updateUser(id, user);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Long id) {
        this.userService.deleteById(id);
    }
}
