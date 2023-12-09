package com.tawfeek.bookstore_admin.service.Impl;

import com.tawfeek.bookstore_admin.entity.AdminUser;
import com.tawfeek.bookstore_admin.exception.RecordNotFoundException;
import com.tawfeek.bookstore_admin.mapper.AdminUserMapper;
import com.tawfeek.bookstore_admin.model.user.UserResponseDTO;
import com.tawfeek.bookstore_admin.repository.AdminUserRepository;
import com.tawfeek.bookstore_admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public UserResponseDTO getUser(Long id) {
       AdminUser adminUser = adminUserRepository.findById(id).orElseThrow(RecordNotFoundException::new);
        return adminUserMapper.toDTO(adminUser);
    }

    @Override
    public List<UserResponseDTO> findUsersByName(String name) {
        List<AdminUser> adminUsers = adminUserRepository.findByUserName(name).orElseThrow(RecordNotFoundException::new);
        return adminUsers.stream().map(user-> adminUserMapper.toDTO(user)).toList();
    }

    @Override
    public UserResponseDTO findUserByEmail(String email) {
        AdminUser adminUser = adminUserRepository.findByEmail(email).orElseThrow(RecordNotFoundException::new);
        return adminUserMapper.toDTO(adminUser);
    }

    @Override
    public List<UserResponseDTO> getAllUsers(){
        return adminUserRepository.findAll().stream().map(user -> adminUserMapper.toDTO(user)).toList();
    }
}
