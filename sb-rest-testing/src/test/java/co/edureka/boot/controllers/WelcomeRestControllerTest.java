package co.edureka.boot.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import co.edureka.boot.services.MessageService;
@WebMvcTest(value = WelcomeRestController.class)
class WelcomeRestControllerTest {
	
	@MockBean //to create a mock object/ substitute object
	private MessageService service;
	
	@Autowired
	private MockMvc mockMvc; //used to send a request to REST API
	
	@Test
	void testShowWelcomeMessage() throws Exception {
		Mockito.when(service.getMessage()).thenReturn("Welcome to edureka..");
		
		mockMvc.perform(MockMvcRequestBuilders.get("/welcome"))
											  .andExpect(MockMvcResultMatchers.status().isOk());	
	}
}
