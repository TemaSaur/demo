package com.example.demo.adapter.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class HeaderController {
	@GetMapping(path = "/all-headers")
	public ResponseEntity<String> getHeaders( @RequestHeader Map<String, String> headers){
		return new ResponseEntity<>(headers.toString(), HttpStatus.OK);
	}
}
