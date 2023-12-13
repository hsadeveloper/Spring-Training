package co.edureka.boot.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edureka.boot.rest.models.Book;

@RestController
@RequestMapping("/library")
public class LibraryRestController {
	@GetMapping(path = "/book", produces = {"application/json", "application/xml"})
	public ResponseEntity<Book> getBookDetails(){
		Book book = new Book();
		
		book.setBookId(908792L);
		book.setBookTitle("Java Complete Reference");
		book.setBookPrice(750.75f);
		book.setAuthor("James Ghosling");
		
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
}
