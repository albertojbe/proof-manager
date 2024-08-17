package com.albertojbe.proofmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ProofManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProofManagerApplication.class, args);
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("pbkdf2", Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8());
        DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder(
                "pbkdf2", encoders);
        passwordEncoder.setDefaultPasswordEncoderForMatches(Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8());
        String hash = passwordEncoder.encode("password");
        System.out.println(hash);


    }

}
