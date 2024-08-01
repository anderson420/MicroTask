package com.example.microtask.controllers;

import com.example.microtask.exceptions.NotFounTaskException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionControllerHandler extends ResponseEntityExceptionHandler {
    private final String PathVariables = "org.springframework.web.servlet.View.pathVariables";
    @ExceptionHandler(NotFounTaskException.class)
    protected ResponseEntity<Object> handleBadRequest(RuntimeException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        body.put("PathVariables", request.getAttribute(PathVariables,WebRequest.SCOPE_REQUEST));
        body.put("error", HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}