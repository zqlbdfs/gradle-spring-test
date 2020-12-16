package com.my.swagger.config;

import com.my.swagger.entity.Result;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<String> errorMsg = fieldErrors.stream().map(o -> o.getDefaultMessage()).collect(Collectors.toList());
        return errorMsg;
    }

    @ExceptionHandler(NullPointerException.class)
    public Result nullPointerException(NullPointerException e) {
        String message = e.getMessage();
        return new Result().fail(e.getMessage());
    }
}
