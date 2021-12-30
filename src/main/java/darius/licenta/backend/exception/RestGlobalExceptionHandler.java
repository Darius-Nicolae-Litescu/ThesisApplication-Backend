package darius.licenta.backend.exception;

import darius.licenta.backend.payload.response.ApiResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class RestGlobalExceptionHandler {

    @ExceptionHandler(value = {UserNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse userNotFoundException(UserNotFoundException ex) {
        return new ApiResponse(ex.getMessage(), "User not found exception", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {RoleNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse roleNotFoundException(RoleNotFoundException ex) {
        return new ApiResponse(ex.getMessage(), "Role not found exception", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse resourceNotFoundException(ResourceNotFoundException ex) {
        return new ApiResponse(ex.getMessage(), "Resource not found exception", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse constraintViolationException(ConstraintViolationException ex) {
        return new ApiResponse(ex.getMessage(), "Constraint violation exception", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {NoHandlerFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse noHandlerFoundException(Exception ex) {
        return new ApiResponse(ex.getMessage(), "No handler found exception", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse unknownException(Exception ex) {
        return new ApiResponse(ex.getMessage(), "Unknown exception", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}