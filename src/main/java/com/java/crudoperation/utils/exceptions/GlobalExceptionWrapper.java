package com.java.crudoperation.utils.exceptions;

import com.java.crudoperation.utils.RestResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

/**
 * Contains all custom exceptions with corresponding constructor enabled.
 */
public class GlobalExceptionWrapper {

    private GlobalExceptionWrapper() {
    }

    /**
     * Returns the bad request exception with the given message and bad request http status code
     */
    @Getter
    public static class BadRequestException extends RuntimeException implements IGlobalException {

        private final HttpStatus httpStatus;

        public BadRequestException(String message) {
            super(message);
            this.httpStatus = HttpStatus.BAD_REQUEST;
        }

        @Override
        public ResponseEntity<RestResponse> getResponse(Exception exception) {
            return ResponseEntity
                    .badRequest()
                    .body(setErrorResponse(exception));  // Use this to send the error response to the client
        }
    }

}
