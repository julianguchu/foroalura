package com.foxcreations.springtest.app.excepcion;

import java.sql.SQLIntegrityConstraintViolationException;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExcepcion {
	

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<?> valoresigualesExcpcion(SQLIntegrityConstraintViolationException e){
		
		
		return new ResponseEntity<String>("el nombre  del topico o el comentario estan repetidos"+e.getSQLState(), HttpStatus.BAD_REQUEST);
	}

}
