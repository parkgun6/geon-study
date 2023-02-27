package org.geon.study.common.exception.restcontroller;

import lombok.extern.log4j.Log4j2;
import org.geon.study.common.exception.response.ErrorResponse;
import org.geon.study.common.exception.runtime.RuntimeExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Log4j2
public class RestControllerExceptionHandler {

    @ExceptionHandler(RuntimeExceptionHandler.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeExceptionHandler ex) {
        ErrorResponse response = new ErrorResponse();
        response.setErrorMsg(ex.getMessage());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<ErrorResponse> handleInternalServerErrorException(Exception ex) {
        ErrorResponse er = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        log.warn(er.toString(), er);
        return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
