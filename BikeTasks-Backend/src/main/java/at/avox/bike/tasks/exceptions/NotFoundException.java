package at.avox.bike.tasks.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends MappedBackendException {
    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
