package com.tawfeek.bookstore_customer.service.Impl;

import com.tawfeek.bookstore_customer.entity.CustomerUser;
import com.tawfeek.bookstore_customer.mapper.AdminUserMapper;
import com.tawfeek.bookstore_customer.model.Role;
import com.tawfeek.bookstore_customer.model.auth.AuthenticationRequest;
import com.tawfeek.bookstore_customer.model.user.UserRequestDTO;
import com.tawfeek.bookstore_customer.repository.CustomerUserRepository;
import com.tawfeek.bookstore_customer.security.JwtService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Optional;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class AuthenticationServiceImplTest {

    @Mock
    private CustomerUserRepository customerUserRepository;

    @Mock
    private  JwtService jwtService;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private PasswordEncoder passwordEncoder;
    @InjectMocks
    private AuthenticationServiceImpl authenticationService;

    @Mock
    private AdminUserMapper userMapper;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void shouldRegisterNewUser() {
        var user=new CustomerUser(1l,"tawfeek shalash","123456", Role.USER,"t.shalash1@gmail.com");
        var userRequestDTO=new UserRequestDTO("tawfeek shalash","123456","t.shalash1@gmail.com");
        when(jwtService.generateToken(user)).thenReturn("token");
        when(userMapper.toEntity(userRequestDTO)).thenReturn(user);
        var authenticationResponse =
                authenticationService
                        .register(userRequestDTO);
        verify(customerUserRepository,times(1)).save(user);
        assertThat(authenticationResponse.getToken()).isNotEmpty();
        assertThat(authenticationResponse.getToken()).isEqualTo("token");

    }

    @Test
    void shouldAuthenticateNewUser() {
        var user=new CustomerUser(1l,"tawfeek shalash","123456", Role.USER,"t.shalash1@gmail.com");
        when(customerUserRepository.findByEmail("t.shalash1@gmail.com")).thenReturn(Optional.of(user));
        when(jwtService.generateToken(user)).thenReturn("token");
        var authenticationResponse =
                authenticationService
                .authenticate(new AuthenticationRequest("t.shalash1@gmail.com","123456"));
        verify(customerUserRepository,times(1)).findByEmail("t.shalash1@gmail.com");
        assertThat(authenticationResponse.getToken()).isNotEmpty();
        assertThat(authenticationResponse.getToken()).isEqualTo("token");
    }
}