package darius.licenta.backend.exception;

public class InvalidUsernameAndPasswordException extends RuntimeException {
    public InvalidUsernameAndPasswordException(String message) {
        super(message);
    }
}