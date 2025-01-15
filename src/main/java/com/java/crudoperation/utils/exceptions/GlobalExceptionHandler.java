package com.java.crudoperation.utils.exceptions;

import com.java.crudoperation.utils.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GlobalExceptionWrapper.BadRequestException.class)
    public ResponseEntity<RestResponse> handleBadRequestException(GlobalExceptionWrapper.BadRequestException e) {
        return e.getResponse(e);  // Get the custom error response
    }

    // Optional: You can handle other exceptions as well here
}
