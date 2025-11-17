package com.example.userprofile.mapper;

import com.example.userprofile.dto.request.CreateUserDTO;
import com.example.userprofile.dto.response.UserResponseDTO;
import com.example.userprofile.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // Optional: if you want to use manual instance
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // Convert CreateUserDTO to User entity
    User toEntity(CreateUserDTO dto);

    // Convert User entity to UserResponseDTO
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    UserResponseDTO toResponse(User user);
}
