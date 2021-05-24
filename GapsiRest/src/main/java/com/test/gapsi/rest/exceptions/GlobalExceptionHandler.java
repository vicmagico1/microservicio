package com.test.gapsi.rest.exceptions;

import javax.annotation.Resource;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@Resource
	private Environment environment;
	   
    @ExceptionHandler
    public ResponseEntity<?> handlerException(Exception e){
    	e.printStackTrace();
    	return new ResponseEntity<>("Error interno", HttpStatus.INTERNAL_SERVER_ERROR);
    	
    }

    // Bad Request
    @ExceptionHandler
    public ResponseEntity<?> handlerBadRequest(HttpMessageNotReadableException e){
    	e.printStackTrace();
    	return new ResponseEntity<>("Peticion incorrecta", HttpStatus.BAD_REQUEST);
    }

    // Argument not valid
    @ExceptionHandler
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException e){
        e.printStackTrace();
        return new ResponseEntity<>("Argumentos de la peticion no validos", HttpStatus.BAD_REQUEST);
        
    }
    
    
}
