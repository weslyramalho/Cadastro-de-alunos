package com.wr.cadastro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericControllerAdivice {
	
	Logger LOGGER = LoggerFactory.getLogger(GenericControllerAdivice.class);
	
	@ExceptionHandler({RecursoInexistenteException.class})
	public ResponseEntity<String> handle(final RecursoInexistenteException e){
		final String recursoInexistente = "Recurso inexistente";
		LOGGER.error(recursoInexistente);
		return new ResponseEntity<>(recursoInexistente, HttpStatus.NOT_FOUND);
	}
	

}
