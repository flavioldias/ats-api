package br.com.sulamerica.ats.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.sulamerica.ats.api.beans.Ats;
import br.com.sulamerica.ats.api.beans.ValidationException;
import br.com.sulamerica.ats.api.service.AtsService;

@RestController
@RequestMapping(value = "ats-api")
@Lazy(true)
public class AtsController {

	@Autowired
	private AtsService service;

	@RequestMapping(value = "upload", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Ats upload(@RequestBody Ats ats) {

		service.trataEntrada(ats);
		service.pdfGeneration(ats);
		
		return ats;

	}

	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public void handleValidationException(ValidationException e){
		
	}

}
