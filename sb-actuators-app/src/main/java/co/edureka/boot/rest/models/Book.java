package co.edureka.boot.rest.models;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
public class Book {
	private Long bookId;
	private String bookTitle;
	private String author;
	private Float bookPrice;
}
