package co.edureka.boot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.edureka.boot.controllers.WelcomeRestController;
import co.edureka.boot.services.MessageService;

@SpringBootTest
class ApplicationTests {
	@Autowired
	WelcomeRestController controller;
	
	@Autowired
	MessageService service;
	
	@Test
	void contextLoads() {
		Assertions.assertThat(controller).isNotNull();
		Assertions.assertThat(service).isNotNull();
	}

}
