package darius.licenta.backend.exception;

import org.springframework.http.HttpStatus;

public class InvalidJwtException extends RuntimeException {
    public InvalidJwtException(String message) {
        super(message);
    }
}