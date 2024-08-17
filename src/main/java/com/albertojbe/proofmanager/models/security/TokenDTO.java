package com.albertojbe.proofmanager.models.security;

import java.util.Date;

public record TokenDTO(
        String username,
        Boolean authenticated,
        Date created,
        Date expired,
        String accessToken,
        String refreshToken) {
}
