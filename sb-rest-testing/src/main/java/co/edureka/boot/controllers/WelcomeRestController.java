package co.edureka.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edureka.boot.services.MessageService;

@RestController
public class WelcomeRestController {
	@Autowired
	private MessageService service;
	
	@GetMapping("/welcome")
	public ResponseEntity<String> showWelcomeMessage(){
		String msg = service.getMessage();
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
