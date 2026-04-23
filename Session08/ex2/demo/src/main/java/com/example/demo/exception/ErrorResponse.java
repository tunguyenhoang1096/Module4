package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
@AllArgsConstructor
@Getter
@Builder
public class ErrorResponse {
    private int status;
    private String message;
    private LocalDateTime timestamp;
}
