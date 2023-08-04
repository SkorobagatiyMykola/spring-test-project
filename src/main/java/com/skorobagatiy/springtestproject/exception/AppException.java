package com.skorobagatiy.springtestproject.exception;

import com.skorobagatiy.springtestproject.exception.models.ApiLink;
import com.skorobagatiy.springtestproject.exception.models.ErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class AppException extends ResponseStatusException {
    private static final ErrorType DEFAULT_ERROR_TYPE = ErrorType.FAILURE;

    private final transient List<ApiLink> links;
    private final ErrorType type;

    public AppException(HttpStatus status, String reason) {
        this(status, reason, DEFAULT_ERROR_TYPE, null, null);
    }

    public AppException(HttpStatus status, String reason, ErrorType type) {
        this(status, reason, type, null, null);
    }

    public AppException(HttpStatus status, String reason, Throwable cause, ErrorType type) {
        this(status, reason, type, cause, null);
    }

    public AppException(HttpStatus status, String reason, ErrorType type, List<ApiLink> links) {
        this(status, reason, type, null, links);
    }

    public AppException(HttpStatus status, String reason, ErrorType type, Throwable cause, List<ApiLink> links) {
        super(status, reason, cause);
        this.type = type;
        this.links = links;
    }

}
