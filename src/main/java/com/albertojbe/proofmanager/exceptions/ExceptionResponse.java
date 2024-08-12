package com.albertojbe.proofmanager.exceptions;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class ExceptionResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String message;
    private String details;
    private LocalDateTime timestamp;

    public ExceptionResponse(String message, String details, LocalDateTime timestamp) {
        this.message = message;
        this.details = details;
        this.timestamp = timestamp;
    }
}
