package clover.mlclover.controllers.exception;


import clover.mlclover.services.exceptions.DataIntegrityException;
import clover.mlclover.services.exceptions.ObjectNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        StandardError err = new StandardError(404, e.getMessage(), System.currentTimeMillis());

        return ResponseEntity.status(404).body(err);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request){
        StandardError err = new StandardError(400, e.getMessage(), System.currentTimeMillis());

        return ResponseEntity.status(400).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request){
        ValidationError err = new ValidationError(400, "Erro de validação", System.currentTimeMillis());
        for(FieldError error: e.getBindingResult().getFieldErrors()){
            err.addError(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.status(400).body(err);
    }

//    @ExceptionHandler(IllegalStateException.class)
//    public ResponseEntity<StandardError> senhaIncorreta(IllegalStateException e, HttpServletRequest request){
//        ValidationError err = new ValidationError(400, "Erro de validação", System.currentTimeMillis());
//        System.out.println(e.getMessage());
//        return ResponseEntity.status(400).body(err);
//    }



}
