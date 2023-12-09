package com.tawfeek.bookstore_admin.mapper;

import com.tawfeek.bookstore_admin.entity.AdminUser;
import com.tawfeek.bookstore_admin.model.user.UserRequestDTO;
import com.tawfeek.bookstore_admin.model.user.UserResponseDTO;

public interface AdminUserMapper {

    public AdminUser toEntity(UserRequestDTO userRequestDTO);

    public UserResponseDTO toDTO(AdminUser adminUser);
}
