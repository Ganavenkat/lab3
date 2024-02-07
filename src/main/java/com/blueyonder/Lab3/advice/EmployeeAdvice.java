package com.blueyonder.Lab3.advice;

import com.blueyonder.Lab3.dto.ErrorMessageDto;
import com.blueyonder.Lab3.exception.EmployeeAlreadyPresent;
import com.blueyonder.Lab3.exception.EmployeeNotPresent;
import com.blueyonder.Lab3.exception.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class EmployeeAdvice {
    @ExceptionHandler(EmployeeNotPresent.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessageDto handleEmployeeNotFound(EmployeeNotPresent exception) {
        return new ErrorMessageDto(exception.getMessage(), HttpStatus.NOT_FOUND.toString());
    }


    @ExceptionHandler(ResourceNotFound.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessageDto handleEmployeeEmailPresent(ResourceNotFound exception) {
        System.out.println("EmployeeEmailPresent" + exception);
        return new ErrorMessageDto(exception.getMessage(), HttpStatus.BAD_REQUEST.toString());
    }


    @ExceptionHandler(EmployeeAlreadyPresent.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessageDto handlEmployeeAlreadyPresent(EmployeeAlreadyPresent exception) {
        return new ErrorMessageDto(exception.getMessage(), HttpStatus.BAD_REQUEST.toString());
    }


}
