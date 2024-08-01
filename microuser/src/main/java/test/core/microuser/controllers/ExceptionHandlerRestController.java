package test.core.microuser.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import test.core.microuser.exception.UserAlreadyExistException;
import test.core.microuser.exception.UserNoFoundException;
import test.core.microuser.exception.UserNullIdException;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerRestController extends ResponseEntityExceptionHandler {

    private final String PathVariables = "org.springframework.web.servlet.View.pathVariables";
    @ExceptionHandler(UserNoFoundException.class)
    protected ResponseEntity<Object> handleNotFound(RuntimeException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        body.put("PathVariables", request.getAttribute(PathVariables,WebRequest.SCOPE_REQUEST));
        body.put("error", HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserAlreadyExistException.class)
    protected ResponseEntity<Object> handleBadRequest(RuntimeException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        body.put("PathVariables", request.getAttribute(PathVariables,WebRequest.SCOPE_REQUEST));
        body.put("error", HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UserNullIdException.class)
    protected ResponseEntity<Object> handleNullIdUser(RuntimeException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        body.put("PathVariables", request.getAttribute(PathVariables,WebRequest.SCOPE_REQUEST));

        body.put("error", HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }


}
