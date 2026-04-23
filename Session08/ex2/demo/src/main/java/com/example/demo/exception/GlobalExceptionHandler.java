package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class) //Lỗi toán học
    public ResponseEntity<ErrorResponse> handleArithmeticException(ArithmeticException e) {
        ErrorResponse err = ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message("Không thể chia cho 0 " + e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class) // Lỗi sai kiểu dữ liệu
    public ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException e) {
        ErrorResponse err = ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message("Dữ liệu nhập vào phải là số "+e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class) // Lỗi hệ thống chung
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>("Lỗi hệ thống "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
