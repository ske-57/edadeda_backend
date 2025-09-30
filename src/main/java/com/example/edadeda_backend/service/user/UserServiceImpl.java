package com.example.edadeda_backend.service.user;

import com.example.edadeda_backend.exception.AlreadyExistingException;
import com.example.edadeda_backend.exception.NotFoundException;
import com.example.edadeda_backend.model.dto.InitDataRequest;
import com.example.edadeda_backend.model.dto.user.UserCreateRequest;
import com.example.edadeda_backend.model.dto.user.UserResponse;
import com.example.edadeda_backend.model.dto.user.UserUpdateRequest;
import com.example.edadeda_backend.model.entity.User;
import com.example.edadeda_backend.repository.UserRepository;
import com.example.edadeda_backend.service.auth.TelegramDataParser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final TelegramDataParser telegramDataParser;

    public UserServiceImpl(UserRepository userRepository, TelegramDataParser telegramDataParser) {
        this.userRepository = userRepository;
        this.telegramDataParser = telegramDataParser;
    }

    private static UserResponse toResponse(User u) {
        return new UserResponse(u.getId(), u.getTgId(), u.getName(), u.getIsSeller());
    }

    @Override
    public UserResponse createUser(InitDataRequest telegramInitDataRequest) {
        TelegramDataParser.Result userData = telegramDataParser.parse(telegramInitDataRequest.getInitData());

        User u = new User();
        u.setTgId(userData.tgId());
        u.setName(userData.name());
        if (userRepository.findByTgId(userData.tgId()).isEmpty()) {
            return toResponse(userRepository.save(u));
        } else {
            return toResponse(u);
        }
    }

    @Override
    public UserResponse getUserByTgId(Long id) {
        return toResponse(userRepository.findByTgId(id)
                .orElseThrow(() -> new NotFoundException("Get:\n User not found")));
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map((UserServiceImpl::toResponse))
                .toList();
    }

    @Override
    public UserResponse updateUser(Long id, UserUpdateRequest req) {
        User u = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Update:\n User with id " + id + " not found"));

        if (req.getName() != null) u.setName(req.getName());
        if (req.getIsSeller() != null ) u.setIsSeller(req.getIsSeller());
        return toResponse(userRepository.save(u));
    }


    @Override
    public void deleteById(Long id) {
        if (!userRepository.existsById(id)) throw new NotFoundException("Delete:\n User with id " + id + " not found");
        userRepository.deleteById(id);
    }
}
