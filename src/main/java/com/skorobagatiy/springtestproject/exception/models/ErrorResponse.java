package com.skorobagatiy.springtestproject.exception.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.ThreadContext;

import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private static final String CORRELATION_ID_HEADER = "X-CORRELATION-ID";

    private final String id;
    private final LocalDate timestamp;
    private final int status;
    private final ErrorType type;
    private final String message;
    private List<ValidationError> errors;
    private List<ApiLink> links;

    public ErrorResponse(int status, ErrorType type, String message) {
        this(status, type, message, null);
    }

    public ErrorResponse(int status, ErrorType type, String message, List<ApiLink> links) {
        this.id = ThreadContext.get(CORRELATION_ID_HEADER);
        this.timestamp = LocalDate.now();
        this.status = status;
        this.type = type;
        this.message = message;
        this.links = links;
    }

    @Getter
    @AllArgsConstructor
    public static class ValidationError {
        private final String field;
        private final String message;
    }

    public void addValidationError(String field, String message){
        if(Objects.isNull(errors)){
            errors = new ArrayList<>();
        }
        errors.add(new ValidationError(field, message));
    }

    public static ErrorResponse fromDefaultAttributeMap(Map<String, Object> defaultErrorAttributes, ErrorType type) {
        return new ErrorResponse(
                (int) defaultErrorAttributes.get("status"),
                type,
                (String) defaultErrorAttributes.getOrDefault("message", "no message available")
        );
    }

    public Map<String, Object> toAttributeMap() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("timestamp", timestamp);
        map.put("status", status);
        map.put("type", type);
        map.put("message", message);
        if (errors != null) {
            map.put("errors", errors);
        }

        return map;
    }
}
