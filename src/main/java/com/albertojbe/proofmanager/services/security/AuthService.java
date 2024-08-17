package com.albertojbe.proofmanager.services.security;

import com.albertojbe.proofmanager.models.security.AccountCredentialsDTO;
import com.albertojbe.proofmanager.models.security.TokenDTO;
import com.albertojbe.proofmanager.repositories.UserRepository;
import com.albertojbe.proofmanager.securityJwt.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    JwtTokenProvider jwtTokenProvider;
    AuthenticationManager authenticationManager;
    UserRepository userRepository;

    public AuthService(JwtTokenProvider jwtTokenProvider, AuthenticationManager authenticationManager, UserRepository userRepository) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    public ResponseEntity<TokenDTO> signIn(AccountCredentialsDTO data){
        try {
            var username = data.username();
            var password = data.password();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            var user = userRepository.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("User not found");
            }
            var token = jwtTokenProvider.createAccessToken(
                    user.getUsername(),
                    user.getRoles());
            return ResponseEntity.ok().body(token);
        } catch (Exception e){
            throw new BadCredentialsException("Invalid username or password");
        }
    }
}
