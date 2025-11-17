package com.example.userprofile.service.impl;

import com.example.userprofile.dto.request.CreateUserDTO;
import com.example.userprofile.dto.response.UserResponseDTO;
import com.example.userprofile.exception.EmailAlreadyExistsException;
import com.example.userprofile.exception.UserNotFoundException;
import com.example.userprofile.mapper.UserMapper;
import com.example.userprofile.model.User;
import com.example.userprofile.repository.UserRepository;
import com.example.userprofile.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    // Constructor injection
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    // ------------------- CREATE -------------------
    @Override
    public UserResponseDTO createUser(CreateUserDTO dto) {
        userRepository.findByEmail(dto.getEmail())
                .ifPresent(u -> {
                    throw new EmailAlreadyExistsException("Email already exists: " + dto.getEmail());
                });

        User user = userMapper.toEntity(dto);
        User saved = userRepository.save(user);
        return userMapper.toResponse(saved);
    }

    // ------------------- READ ALL -------------------
    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toResponse)
                .collect(Collectors.toList());
    }

    // ------------------- READ BY ID -------------------
    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        return userMapper.toResponse(user);
    }

    // ------------------- UPDATE -------------------
    @Override
    public UserResponseDTO updateUser(Long id, CreateUserDTO dto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        // Check if the new email exists for another user
        userRepository.findByEmail(dto.getEmail())
                .ifPresent(u -> {
                    if (!u.getId().equals(id)) {
                        throw new EmailAlreadyExistsException("Email already exists: " + dto.getEmail());
                    }
                });

        existingUser.setName(dto.getName());
        existingUser.setEmail(dto.getEmail());

        User updated = userRepository.save(existingUser);
        return userMapper.toResponse(updated);
    }

    // ------------------- DELETE -------------------
    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        userRepository.delete(user);
    }
}

