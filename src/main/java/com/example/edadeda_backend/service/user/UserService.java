package com.example.edadeda_backend.service.user;


import com.example.edadeda_backend.model.dto.user.UserCreateRequest;
import com.example.edadeda_backend.model.dto.user.UserResponse;
import com.example.edadeda_backend.model.dto.user.UserUpdateRequest;

import java.util.List;

public interface UserService {
    UserResponse create(UserCreateRequest req);
    UserResponse get (Long id);
    List<UserResponse> findAll();
    UserResponse update(Long id, UserUpdateRequest req);
    void delete(Long id);
}
