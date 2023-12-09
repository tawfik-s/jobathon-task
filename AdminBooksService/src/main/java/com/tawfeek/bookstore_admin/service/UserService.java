package com.tawfeek.bookstore_admin.service;

import com.tawfeek.bookstore_admin.model.user.UserResponseDTO;

import java.util.List;

public interface UserService {

    public UserResponseDTO getUser(Long id);

    public List<UserResponseDTO> findUsersByName(String name);

    public UserResponseDTO findUserByEmail(String email);

    public List<UserResponseDTO> getAllUsers();
}
