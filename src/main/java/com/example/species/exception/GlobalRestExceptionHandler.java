package com.example.species.exception;

import com.example.species.dto.ErrorDto;
import com.example.species.dto.InvalidEntityErrorDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalRestExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorDto> handleEntityNotFound(EntityNotFoundException e, HttpServletRequest request) {
        ErrorDto errorDto = new ErrorDto(LocalDateTime.now(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
    }

    @ExceptionHandler({EntityToCreateHasAnIdException.class, EntityToUpdateHasNoIdException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDto> handleBadRequest(RuntimeException e, HttpServletRequest request) {
        ErrorDto errorDto = new ErrorDto(LocalDateTime.now(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<InvalidEntityErrorDto> handleValidationExceptions(MethodArgumentNotValidException e, HttpServletRequest request) {
        BindingResult bindingResult = e.getBindingResult();
        InvalidEntityErrorDto errorDto = new InvalidEntityErrorDto(LocalDateTime.now(), "Validation failed", request.getRequestURI(), bindingResult);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }
} 