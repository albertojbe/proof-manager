package com.albertojbe.proofmanager.models.user;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;
import java.io.Serializable;

@EqualsAndHashCode
@Entity
public class Permission implements Serializable, GrantedAuthority {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    public Permission() {

    }

    @Override
    public String getAuthority() {
        return this.description;
    }
}
