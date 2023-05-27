package com.example.demo.adapter.web.controller;

import com.example.demo.exception.BadGatewayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ExceptionController {
	@GetMapping(value = "/exception", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<String> testException(@RequestParam(required = false, defaultValue = "false") boolean exception) throws BadGatewayException {
		if (exception){
			throw new BadGatewayException("It was our exception :sad:");
		}
		return new ResponseEntity<>("OK :ok:", HttpStatus.OK);
	}
}
