package co.edureka.boot.services;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
	public String getMessage() {
		return "Welcome to Spring Boot Testing @ edureka";
	}
}
