package com.inzi.sim_service.exception;

import com.inzi.sim_service.dto.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidSimException.class)
    public ResponseEntity<ErrorResponse> handleInvalidSimException(
            InvalidSimException exception,
            WebRequest webRequest
    ){
        ErrorResponse errorResponse = new ErrorResponse(new Date(),exception.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ErrorResponse> handleInvalidInputException(
            InvalidInputException e,
            WebRequest webRequest
    ){
        ErrorResponse errorResponse = new ErrorResponse(new Date(),e.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(
            ResourceNotFoundException exception,
            WebRequest webRequest
    ){
        ErrorResponse errorResponse = new ErrorResponse(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode statusCode, WebRequest request
    )
    {
        Map<String, String > errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(
                (error) ->{
                    String field = ((FieldError)error).getField();
                    String message = error.getDefaultMessage();
                    errors.put(field,message);
                }
        );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}