package com.tawfeek.bookstore_customer.service;

import com.tawfeek.bookstore_customer.model.auth.AuthenticationRequest;
import com.tawfeek.bookstore_customer.model.auth.AuthenticationResponse;
import com.tawfeek.bookstore_customer.model.user.UserRequestDTO;

public interface AuthenticationService {

    public AuthenticationResponse register(UserRequestDTO request);

    public AuthenticationResponse authenticate(AuthenticationRequest request);


}
