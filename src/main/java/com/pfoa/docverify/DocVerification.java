package com.pfoa.docverify;

import java.io.InputStream;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pfoa.docverify.dto.DocDetails;

@SpringBootApplication
@RestController
public class DocVerification {

	public static void main(String[] args) {
		SpringApplication.run(DocVerification.class, args);
	}

	//To show the documents owned by a user
	@GetMapping("/documents")
	public DocDetails getDocs(@RequestParam(value = "user", defaultValue = "Not a valid user") String name) {
		return new DocDetails("Sample", new Date(), name);
	}
	
	//End point to get insights
	@GetMapping("/index")
	public String getHtml() {
		//hard coding for the development purpose
		String filePath = "C:\\Users\\user\\Desktop\\pfoa-ui\\test_ajax_test.html";
		InputStream in = getClass()
			      .getResourceAsStream(filePath);
			    return in.toString();
	}

}
