package com.tawfeek.bookstore_admin.service;

import com.tawfeek.bookstore_admin.model.auth.AuthenticationRequest;
import com.tawfeek.bookstore_admin.model.auth.AuthenticationResponse;
import com.tawfeek.bookstore_admin.model.user.UserRequestDTO;

public interface AuthenticationService {

    public AuthenticationResponse register(UserRequestDTO request);

    public AuthenticationResponse authenticate(AuthenticationRequest request);


}
