package com.login.login.exception;

import com.login.login.service.oauth2.dto.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler{
    public static final String ERROR_MSG = "ERROR";

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ApiResponse forbiddenException(RuntimeException e){
        log.error("",e);
        return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, ERROR_MSG);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(CustomException.class)
    public ApiResponse forbiddenException(CustomException e){
        return new ApiResponse(e.getCustomMessage().getHttpStatus(), e.getCustomMessage().getMessage());
    }
}
