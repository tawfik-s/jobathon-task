package com.tawfeek.bookstore_customer.mapper;

import com.tawfeek.bookstore_customer.entity.CustomerUser;
import com.tawfeek.bookstore_customer.model.user.UserRequestDTO;
import com.tawfeek.bookstore_customer.model.user.UserResponseDTO;

public interface AdminUserMapper {

    public CustomerUser toEntity(UserRequestDTO userRequestDTO);

    public UserResponseDTO toDTO(CustomerUser customerUser);
}
