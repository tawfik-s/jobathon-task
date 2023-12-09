package com.tawfeek.bookstore_customer.service.Impl;

import com.tawfeek.bookstore_customer.entity.CustomerUser;
import com.tawfeek.bookstore_customer.mapper.AdminUserMapper;
import com.tawfeek.bookstore_customer.model.Role;
import com.tawfeek.bookstore_customer.model.user.UserResponseDTO;
import com.tawfeek.bookstore_customer.repository.CustomerUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;


import static org.hamcrest.MatcherAssert.assertThat;


@ExtendWith(MockitoExtension.class)
class CustomerUserServiceImplTest {

    @Mock
    private CustomerUserRepository customerUserRepository;

    @Mock
    private AdminUserMapper adminUserMapper;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void shouldGetUser() {
        var user=new CustomerUser(1L,"tawfeek","123456", Role.USER,"t.shalash1@gmail.com");
        when(customerUserRepository.findById(1L)).thenReturn(Optional.of(user));
        when(adminUserMapper.toDTO(user)).thenReturn(new UserResponseDTO(1L,"tawfeek","t.shalash1@gmail.com"));
        var res = userService.getUser(1L);
        assertThat(res).isNotNull();
        verify(customerUserRepository,times(1)).findById(1L);
        assertThat(res.getEmail()).isEqualTo("t.shalash1@gmail.com");

    }

    @Test
    void shouldGetUserByName() {
        var user1=new CustomerUser(1L,"tawfeek","123456", Role.USER,"t.shalash1@gmail.com");
        var user2=new CustomerUser(2L,"tawfeek","123456", Role.USER,"t.shalash1@gmail.com");
        List<CustomerUser> arr1=new ArrayList<>();
        arr1.add(user1);
        arr1.add(user2);
        when(customerUserRepository.findByUserName("tawfeek")).thenReturn(Optional.of(arr1));
        when(adminUserMapper.toDTO(user1)).thenReturn(new UserResponseDTO(1L,"tawfeek","t.shalash1@gmail.com"));
        when(adminUserMapper.toDTO(user2)).thenReturn(new UserResponseDTO(2L,"tawfeek","t.shalash1@gmail.com"));
        var res = userService.findUsersByName("tawfeek");
        assertThat(res).isNotNull();
        verify(customerUserRepository,times(1)).findByUserName("tawfeek");
        assertThat(res.size()).isEqualTo(2);
    }

    @Test
    void shouldGetUserByEmail() {
        var user=new CustomerUser(1L,"tawfeek","123456", Role.USER,"t.shalash1@gmail.com");
        when(customerUserRepository.findByEmail("t.shalash1@gmail.com")).thenReturn(Optional.of(user));
        when(adminUserMapper.toDTO(user)).thenReturn(new UserResponseDTO(1L,"tawfeek","t.shalash1@gmail.com"));
        var res = userService.findUserByEmail("t.shalash1@gmail.com");
        assertThat(res).isNotNull();
        verify(customerUserRepository,times(1)).findByEmail("t.shalash1@gmail.com");
        assertThat(res.getEmail()).isEqualTo("t.shalash1@gmail.com");
    }
}