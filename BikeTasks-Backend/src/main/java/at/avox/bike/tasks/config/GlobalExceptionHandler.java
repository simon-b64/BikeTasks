package at.avox.bike.tasks.config;

import at.avox.bike.tasks.controller.dto.ErrorResponseDto;
import at.avox.bike.tasks.exceptions.MappedBackendException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MappedBackendException.class)
    public ResponseEntity<ErrorResponseDto> handleMappedBackendException(MappedBackendException ex) {
        log.warn("Business exception: status={}, message={}", ex.getHttpStatus(), ex.getMessage());
        var error = new ErrorResponseDto(
            ex.getHttpStatus().name(),
            ex.getMessage()
        );
        return ResponseEntity.status(ex.getHttpStatus()).body(error);
    }

}
