package com.flexi.siesta.ordermanagement.exception;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Builder
public class ApiError {
    private LocalDateTime timestamp = LocalDateTime.now();
    private HttpStatus status;
    private String error;
    private String message;
    private String trace;
}
