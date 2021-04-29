package com.joaogcm.api.restful.gerenciamento.pessoas.controller.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.joaogcm.api.restful.gerenciamento.pessoas.service.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		String error = "Não encontrado.";

		StandardError standard = new StandardError(System.currentTimeMillis(), status.value(), error, e.getMessage(),
				request.getRequestURI());

		return ResponseEntity.status(status).body(standard);
	}
}