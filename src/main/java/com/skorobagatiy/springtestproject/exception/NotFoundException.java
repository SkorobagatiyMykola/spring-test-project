package com.skorobagatiy.springtestproject.exception;

import com.skorobagatiy.springtestproject.exception.models.ErrorType;
import org.springframework.http.HttpStatus;

public class NotFoundException extends AppException{
    public NotFoundException(String reason) {
        super(HttpStatus.NOT_FOUND, reason, ErrorType.FAILURE);
    }
}
