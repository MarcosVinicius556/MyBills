package com.dev.marcos.mybills.controllers.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dev.marcos.mybills.services.exceptions.ResourceNotFoundException;
import com.dev.marcos.mybills.services.exceptions.UserAlreadyExistsException;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Intercepta as exceções lançadas pelo sistema
 * para que possam ter tratativas e códigos
 * personalizadas para cada uma 
 */
@ControllerAdvice
public class ControllerExceptionHandler extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<StandardError> userAlreadyExists(UserAlreadyExistsException e, HttpServletRequest request) {
        String error = "User already exists";
        HttpStatus status = HttpStatus.CONFLICT; //409 - CONFLICT
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}
