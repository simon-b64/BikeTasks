package at.avox.bike.tasks.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MappedBackendException extends RuntimeException {
    private final HttpStatus httpStatus;

    public MappedBackendException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
