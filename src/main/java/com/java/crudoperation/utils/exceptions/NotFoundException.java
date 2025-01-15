package com.java.crudoperation.utils.exceptions;

import com.java.crudoperation.utils.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class NotFoundException extends RuntimeException {

    private final HttpStatus httpStatus;

    public NotFoundException(String message) {
        super(message);
        this.httpStatus = HttpStatus.NOT_FOUND;  // HTTP 404 status code
    }

    public ResponseEntity<RestResponse> getResponse() {
        RestResponse restResponse = new RestResponse();
        restResponse.setStatus(false);
        restResponse.setMessage(this.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restResponse);  // Return 404 Not Found response
    }
}
