package com.example.edadeda_backend.controller;

import com.example.edadeda_backend.model.dto.InitDataRequest;
import com.example.edadeda_backend.model.dto.user.UserCreateRequest;
import com.example.edadeda_backend.model.dto.user.UserResponse;
import com.example.edadeda_backend.model.dto.user.UserUpdateRequest;
import com.example.edadeda_backend.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Users")
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Get users list")
    @GetMapping()
    public List<UserResponse> getUsers() {
        return this.userService.getAllUsers();
    }

    @Operation(summary = "Create new user")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody InitDataRequest telegramInitData) {
        return this.userService.createUser(telegramInitData);
    }

    @Operation(summary = "Get user id by telegram id")
    @GetMapping(path = "/{tgId}")
    public UserResponse getUserById(@PathVariable Long tgId) {
        return this.userService.getUserByTgId(tgId);
    }

    @Operation(summary = "Partially update user")
    @PatchMapping(path = "/{id}")
    public UserResponse updateUser(@PathVariable Long id, @RequestBody UserUpdateRequest user) {
        return this.userService.updateUser(id, user);
    }

    @Operation(summary = "Delete user by id")
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        this.userService.deleteById(id);
    }
}
