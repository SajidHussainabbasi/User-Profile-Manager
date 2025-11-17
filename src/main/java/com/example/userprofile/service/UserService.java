package com.example.userprofile.service;

import com.example.userprofile.dto.request.CreateUserDTO;
import com.example.userprofile.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {

    // Create
    UserResponseDTO createUser(CreateUserDTO dto);

    // Read all
    List<UserResponseDTO> getAllUsers();

    // Read by ID
    UserResponseDTO getUserById(Long id);

    // Update
    UserResponseDTO updateUser(Long id, CreateUserDTO dto);

    // Delete
    void deleteUser(Long id);
}
