package com.tawfeek.bookstore_admin.mapper.Impl;


import com.tawfeek.bookstore_admin.entity.AdminUser;
import com.tawfeek.bookstore_admin.mapper.AdminUserMapper;
import com.tawfeek.bookstore_admin.model.Role;
import com.tawfeek.bookstore_admin.model.user.UserRequestDTO;
import com.tawfeek.bookstore_admin.model.user.UserResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class AdminMapperImplAdmin implements AdminUserMapper {

    @Override
    public  AdminUser toEntity(UserRequestDTO userRequestDTO) {
        AdminUser newUser = new AdminUser();
        newUser.setUserName(userRequestDTO.getUserName());
        newUser.setPassword(userRequestDTO.getPassword());
        newUser.setEmail(userRequestDTO.getEmail());
        newUser.setRole(Role.USER);
        return newUser;
    }

    @Override
    public  UserResponseDTO toDTO(AdminUser user) {
        UserResponseDTO newUserResponseDTO = new UserResponseDTO();
        newUserResponseDTO.setId(user.getId());
        newUserResponseDTO.setUserName(user.getActualName());
        newUserResponseDTO.setEmail(user.getEmail());
        return newUserResponseDTO;
    }
}