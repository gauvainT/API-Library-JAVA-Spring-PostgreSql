package com.sogeti.controllers;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.sogeti.bouchon.AuthorBouchonService;
import com.sogeti.bouchon.BouchonRequest;
import com.sogeti.library.controllers.AuthorController;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT) 
public class AuthorControllerTest {
	
	
	private AuthorController authorController = new AuthorController();
	
	@Test
	
	public void testAddAuthor() {
		
		//authorController.setIAuthorService(new AuthorBouchonService());
		//ServerResponse response = authorController.addAuthor(new BouchonRequest());
		//Assert.assertEquals(Integer.valueOf(200), response.getCode());
	}
}
