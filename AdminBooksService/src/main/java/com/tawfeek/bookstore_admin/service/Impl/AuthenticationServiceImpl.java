package com.tawfeek.bookstore_admin.service.Impl;


import com.tawfeek.bookstore_admin.mapper.AdminUserMapper;
import com.tawfeek.bookstore_admin.model.auth.AuthenticationRequest;
import com.tawfeek.bookstore_admin.model.auth.AuthenticationResponse;
import com.tawfeek.bookstore_admin.model.user.UserRequestDTO;
import com.tawfeek.bookstore_admin.repository.AdminUserRepository;
import com.tawfeek.bookstore_admin.security.JwtService;
import com.tawfeek.bookstore_admin.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AdminUserRepository adminUserRepository;
    @Autowired
    private AdminUserMapper adminUserMapper;

    @Autowired
    private JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;


    public AuthenticationResponse register(UserRequestDTO request) {
        var user = adminUserMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        adminUserRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .id(user.getId())
                .email(user.getEmail())
                .userName(user.getActualName())
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = adminUserRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .id(user.getId())
                .email(user.getEmail())
                .userName(user.getActualName())
                .build();
    }
}
