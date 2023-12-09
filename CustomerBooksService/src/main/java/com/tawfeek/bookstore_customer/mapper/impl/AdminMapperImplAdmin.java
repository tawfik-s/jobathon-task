package com.tawfeek.bookstore_customer.mapper.Impl;


import com.tawfeek.bookstore_customer.entity.CustomerUser;
import com.tawfeek.bookstore_customer.mapper.AdminUserMapper;
import com.tawfeek.bookstore_customer.model.Role;
import com.tawfeek.bookstore_customer.model.user.UserRequestDTO;
import com.tawfeek.bookstore_customer.model.user.UserResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class AdminMapperImplAdmin implements AdminUserMapper {

    @Override
    public CustomerUser toEntity(UserRequestDTO userRequestDTO) {
        CustomerUser newUser = new CustomerUser();
        newUser.setUserName(userRequestDTO.getUserName());
        newUser.setPassword(userRequestDTO.getPassword());
        newUser.setEmail(userRequestDTO.getEmail());
        newUser.setRole(Role.USER);
        return newUser;
    }

    @Override
    public  UserResponseDTO toDTO(CustomerUser user) {
        UserResponseDTO newUserResponseDTO = new UserResponseDTO();
        newUserResponseDTO.setId(user.getId());
        newUserResponseDTO.setUserName(user.getActualName());
        newUserResponseDTO.setEmail(user.getEmail());
        return newUserResponseDTO;
    }
}