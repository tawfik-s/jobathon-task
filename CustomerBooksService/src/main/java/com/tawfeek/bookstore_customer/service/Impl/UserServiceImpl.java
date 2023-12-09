package com.tawfeek.bookstore_customer.service.Impl;

import com.tawfeek.bookstore_customer.entity.CustomerUser;
import com.tawfeek.bookstore_customer.exception.RecordNotFoundException;
import com.tawfeek.bookstore_customer.mapper.AdminUserMapper;
import com.tawfeek.bookstore_customer.model.user.UserResponseDTO;
import com.tawfeek.bookstore_customer.repository.CustomerUserRepository;
import com.tawfeek.bookstore_customer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private CustomerUserRepository customerUserRepository;

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public UserResponseDTO getUser(Long id) {
       CustomerUser customerUser = customerUserRepository.findById(id).orElseThrow(RecordNotFoundException::new);
        return adminUserMapper.toDTO(customerUser);
    }

    @Override
    public List<UserResponseDTO> findUsersByName(String name) {
        List<CustomerUser> customerUsers = customerUserRepository.findByUserName(name).orElseThrow(RecordNotFoundException::new);
        return customerUsers.stream().map(user-> adminUserMapper.toDTO(user)).toList();
    }

    @Override
    public UserResponseDTO findUserByEmail(String email) {
        CustomerUser customerUser = customerUserRepository.findByEmail(email).orElseThrow(RecordNotFoundException::new);
        return adminUserMapper.toDTO(customerUser);
    }

    @Override
    public List<UserResponseDTO> getAllUsers(){
        return customerUserRepository.findAll().stream().map(user -> adminUserMapper.toDTO(user)).toList();
    }
}
