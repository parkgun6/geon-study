package org.geon.study.common.exception.runtime;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RuntimeExceptionHandler extends RuntimeException{

    private HttpStatus httpStatus;

    public RuntimeExceptionHandler(String errorMsg, HttpStatus httpStatus) {
        super(errorMsg);
        this.httpStatus = httpStatus;
    }

}
