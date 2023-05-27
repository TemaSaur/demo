package com.example.demo.adapter.web.advice;

import com.example.demo.adapter.web.annotation.ApiAdvice;
import com.example.demo.exception.BadGatewayException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_GATEWAY;
import static org.springframework.http.ResponseEntity.status;

@ApiAdvice
public class BadGatewayAdvice {
	@ExceptionHandler({BadGatewayException.class})
	public ResponseEntity<String> badGateway(Exception e) {
		return status(BAD_GATEWAY).body(e.getMessage());
	}
}
